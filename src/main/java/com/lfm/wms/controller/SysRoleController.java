package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.*;
import com.lfm.wms.model.*;
import com.lfm.wms.ret.RetCode;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author lfm
 * @date 2019/11/30 - 16:09
 */
@Controller
@RequestMapping("SysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ActionService actionService;
    @Autowired
    private SysPermissionInitService sysPermissionInitService;
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private ActionPermService actionPermService;
    private SysRole sysRole1;
    @RequestMapping("/getAll")
    @ResponseBody
    public RetResult<List<SysRole>> selectAllRole(SysRole sysRole, @RequestParam("limit") int limit, @RequestParam("page") int page){
        PageInfo<SysRole> pageInfo=sysRoleService.getAll(sysRole, page, limit);
        List<SysRole> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @RequestMapping("/addRole")
    @ResponseBody
    public RetResult<Object> addRole(SysRole sysRole){
        sysRole.setCreateTime(new Date());
        System.out.println(sysRole.toString());
        String RoleName=sysRole.getRoleName();
        SysRole result=sysRoleService.selectByRoleName(RoleName);
        if(result!=null){
            return RetResponse.makeRsp(400,"角色名已存在");
        }
        else {
            sysRoleService.addRole(sysRole);
            return RetResponse.makeOKRsp();
        }
    }
    @ResponseBody
    @RequestMapping("/deleteRole")
    public RetResult<Object>delteRole(@RequestParam("id") Integer id){
        sysRoleService.deleteRole(id);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/updateRole")
    public RetResult<Object>updateRole(SysRole sysRole){
        sysRoleService.updateRole(sysRole);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping("/selectRoleUser")
    public String selectRoleUser(SysRole sysRole, Model model){
        System.out.println(sysRole);
        sysRole1=sysRole;
        model.addAttribute("sysRole",sysRole);
    return "/system/role/bindUser";
    }

    @ResponseBody
    @RequestMapping("/selectRoleUser1")
    public RetResult<List<UserInfo>> selectRoleUser1( @RequestParam("limit") int limit, @RequestParam("page") int page){
//        System.out.println("sysRole1="+sysRole1);
        PageInfo<UserInfo> pageInfo=sysRoleService.selectRoleUser1(sysRole1, page, limit);
        List<UserInfo> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("/bindUser")
    public RetResult<Object>bineUser(String data){

        List<UserInfo> userInfos = JSON.parseArray(data,UserInfo.class);//将json数组转为集合
        List<BindUser> bindUsers=new ArrayList<>();
        for (UserInfo userInfo:userInfos){
           BindUser bindUser=new BindUser();
           bindUser.setUid(userInfo.getId());
           bindUser.setSid(sysRole1.getId());
           bindUsers.add(bindUser);
        }

     sysRoleService.bindUser1(bindUsers);
      return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/deleteBindUser")
    public RetResult<Object> deleteBindUser(UserInfo userInfo){
       Integer u_id= userInfo.getId();
       Integer s_id=sysRole1.getId();
       sysRoleService.deleteBindUser(u_id,s_id);
       return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/selectNoBindRoleUser")
    public RetResult<List<UserInfo>>selectNoBindRoleUser(@RequestParam("limit") int limit, @RequestParam("page") int page){
        PageInfo<UserInfo> pageInfo=sysRoleService.selectNoBindRoleUser(sysRole1, page, limit);
        List<UserInfo> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("/selectAllAction")
    public RetResult<List<Action>> selectAllAction(@RequestParam("page") int page, @RequestParam("limit") int limit){
        PageInfo<Action> pageInfo=actionService.selectAllAction(sysRole1,page,limit);
        List<Action> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("/addAction")
    public RetResult<Object> addAction(Action action){
        String actionName=action.getActionName();
        String url=action.getUrl();
        Integer id=sysRole1.getId();
        String founder=id.toString();
        Map<String,Object>map=new HashMap<>();
        map.put("actionName",actionName);
        map.put("url",url);
        map.put("founder",founder);
        actionService.addAction(map);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/selectNoAction")
    public RetResult<List<Action>>selectNoAction(@RequestParam("page") int page, @RequestParam("limit") int limit ){
        PageInfo<Action> pageInfo=actionService.selectNoAction(sysRole1,page,limit);
        List<Action> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("/bindperm")
    public RetResult<Object> bindPerm(Action action){
//        如果action取出founder字段
        String founer=action.getFounder();
        Integer roleid=sysRole1.getId();
//        根据founder的id取出roleValue的值
       String roleValue= sysRoleService.getRoleValue(Integer.valueOf(founer));
//        对perm表进行更新操作
        String prem="authc"+",roles["+roleValue+""+"]";
        String url=action.getUrl();
//        对action表的mode字段进行更改
//        sysPermissionInitService.updatepermurl(prem,url);
        SysPermissionInit sysPermissionInit=new SysPermissionInit();
        sysPermissionInit.setUrl(url);
        sysPermissionInit.setPermissionInit(prem);
        sysPermissionInitService.insertpermurl(sysPermissionInit);
//        获取插入后的id
        Integer afferId=sysPermissionInit.getId();
//        更新权限
        shiroService.updatePermission();
        //        将记录写进action_perm表中
        actionPermService.insertpermroid(action.getId().toString(),afferId.toString());
        actionService.updateActionmodifie(sysRole1.getId().toString(),action.getId());
        return RetResponse.makeOKRsp();
    }
}
