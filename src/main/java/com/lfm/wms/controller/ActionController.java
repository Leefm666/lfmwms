package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.ActionPermService;
import com.lfm.wms.Service.ActionService;
import com.lfm.wms.Service.SysPermissionInitService;
import com.lfm.wms.model.Action;
import com.lfm.wms.model.SysRole;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/11 - 10:40
 */
@Controller
@RequestMapping("Action")
public class ActionController {
    @Autowired
    private ActionService actionService;
    @Autowired
    private ActionPermService actionPermService;
    @Autowired
    private SysPermissionInitService sysPermissionInitService;
    /*@ResponseBody
    @RequestMapping("/selectAllAction")
    public RetResult<List<Action>> selectAllAction(@RequestParam("limit") int limit, @RequestParam("page") int page){
        PageInfo<Action> pageInfo=actionService.selectAllAction(limit,page);
        List<Action> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }*/
    /*@ResponseBody
    @RequestMapping("/addAction")
    public RetResult<Object> addAction(Action action){
        actionService.addAction(action);
        return RetResponse.makeOKRsp();
    }*/
    @ResponseBody
    @RequestMapping("deleteAction")
    public  RetResult<Object> deleteAction(Action action){
        actionService.deleteAction(action);
//        删除最后权限表的记录
        Integer actionid=action.getId();
//        从action_perm表中找出权限所在的id
        String perinitid=actionPermService.selectPerInitId(action);
//        删除权限表的记录
        sysPermissionInitService.deletepermission(perinitid);
//        删除action_perm的记录
        actionPermService.deleteActionPerm(action);
        return RetResponse.makeOKRsp();
    }
}
