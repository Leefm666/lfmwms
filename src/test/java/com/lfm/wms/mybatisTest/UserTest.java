package com.lfm.wms.mybatisTest;

import com.lfm.wms.Service.*;

import com.lfm.wms.core.utils.DateUtil;
import com.lfm.wms.core.utils.StringUtil;
import com.lfm.wms.dao.GoodsMapper;
import com.lfm.wms.dao.PurchaseListMapper;
import com.lfm.wms.dao.SupplierMapper;
import com.lfm.wms.model.*;
import org.apache.shiro.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.*;

/**
 * @author lfm
 * @date 2019/11/16 - 21:58
 */

@SpringBootTest

public class UserTest {
  @Autowired
    private UserInfoService userInfoService;
  @Autowired
    private UserRoleService userRoleService;
    @Resource
    private RolePermService rolePermService;
    @Autowired
    private SysPermissionInitService sysPermissionInitService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private ActionService actionService;
    @Autowired
    private ActionPermService actionPermService;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private SupplierMapper supplierMapper;
    @Autowired
    private PurchaseListService purchaseListService;
    @Resource
    private PurchaseListMapper purchaseListMapper;
    @Test
    public void selectByName(){
        UserInfo userInfo =userInfoService.selectByName("mr_beany");
        System.out.println(userInfo.getId());
        List<String> roleList = userRoleService.getRolesByUserId(1);
        List<String> permList = rolePermService.getPermsByUserId(1);
        System.out.println(roleList);
        System.out.println(permList);


    }
    @Test
    public void updateUser(){
        UserInfo userInfo=new UserInfo();
        userInfo.setId(2);
        userInfo.setUserName("leefminmmm");
        userInfoService.updateUser(userInfo);
        System.out.println("成功修改");
    }
    @Test
    public void deleteUser(){
        userInfoService.deleteUser(11);
        System.out.println("删除成功");
    }
    @Test
    public void prem(){
        List<SysPermissionInit> list=sysPermissionInitService.selectAllOrderBySort();
        System.out.println("总数据条数="+list.size());
    }
    @Test
    public void selectAllRole(){
    /*    SysRole sysRole=new SysRole();
        List<SysRole> list=sysRoleService.getAll(sysRole,1,10);*/
    }
    @Test
    public void addRole(){
        SysRole sysrole=new SysRole();
        sysrole.setRoleName("经理");
        sysrole.setRoleDesc("管理全部");
        sysrole.setRoleValue("jl");
        sysrole.setCreateTime(new Date());
        sysrole.setIsDisable(1);
        Integer total=sysRoleService.addRole(sysrole);
        System.out.println(total);
    }
    @Test
    public void selectByRoleName(){
        SysRole sysRole=new SysRole();
        sysRole =sysRoleService.selectByRoleName("人事");
        System.out.println(sysRole);
    }
    @Test
    public void deleteRole(){
       int total= sysRoleService.deleteRole(3);
        System.out.println(total);
    }
    @Test
    public void updateRole(){
        SysRole sysRole=new SysRole();
        sysRole.setId(14);
        sysRole.setRoleName("经理1");
        sysRole.setRoleDesc("管理1");
        sysRole.setRoleValue("kkk");
        sysRole.setIsDisable(1);
        sysRoleService.updateRole(sysRole);
        System.out.println("更改role成功");
    }
   @Test
    public void selectRoleUser(){
        SysRole sysRole=new SysRole();
        sysRole.setId(1);
       List<String> list= sysRoleService.selectRoleUser(sysRole);
       System.out.println(list);
       Object[] array = list.toArray();
       System.out.println(array);
       List<UserInfo> userInfoList=new ArrayList<>() ;
       for(Object element:array){
           UserInfo userInfo=userInfoService.selectById( Integer.parseInt((String) element));
           userInfoList.add(userInfo);
       }
   }
   @Test
   public void selectRoleUser1() {
     /*  SysRole sysRole=new SysRole();
       sysRole.setId(1);
       List<UserInfo> list= sysRoleService.selectRoleUser1(sysRole);
       System.out.println(list.size());
       for(UserInfo userInfo:list){
           System.out.println(userInfo);
       }
   */
   }
   @Test
    public void bindUser(){
        sysRoleService.bindUser(1,4);
   }
    @Test
    public void bindUser1(){
        List<BindUser> bindUsers=new ArrayList<>();
        BindUser bindUser=new BindUser();
        bindUser.setSid(4);
        bindUser.setUid(2);
        BindUser bindUser1=new BindUser();
        bindUser1.setSid(4);
        bindUser1.setUid(1);
        bindUsers.add(bindUser);
        bindUsers.add(bindUser1);
        sysRoleService.bindUser1(bindUsers);
    }
    @Test
    public void getRoleValue(){
        System.out.println("roid="+sysRoleService.getRoleValue(1));
    }
    @Test
    public void updatepermurl(){
        sysPermissionInitService.updatepermurl("ff","ff");
    }
    @Test
    public  void updateActionmodifie(){
        actionService.updateActionmodifie("2",1);
    }
    @Test
    public void insertperm(){
        SysPermissionInit sysPermissionInit=new SysPermissionInit();
        sysPermissionInit.setPermissionInit("dddd");
        sysPermissionInit.setUrl("dddd");
        sysPermissionInitService.insertpermurl(sysPermissionInit);
        Integer id=sysPermissionInit.getId();
        System.out.println("id="+id);
    }
    @Test
    public  void insertpermroid(){
        actionPermService.insertpermroid("1","1");
    }
    @Test
    public  void selectPerInitId(){
        Action action=new Action();
        action.setId(5);
        System.out.println("perinitid="+actionPermService.selectPerInitId(action));  actionPermService.selectPerInitId(action);
    }
    @Test
    public void  deletepermission(){
        sysPermissionInitService.deletepermission("30");
    }
    @Test
    public void delectActionPerm(){
        Action action=new Action();
        action.setId(6);
        actionPermService.deleteActionPerm(action);
    }
    @Test
    public void selectAllGoods(){
    /*    Goods goods=new Goods();
        List<Goods> list=new ArrayList();
        list=goodsMapper.selectAllGoods(goods);
        for (Goods lost:list){
            System.out.println(lost);
        }
        System.out.println(list.size());*/
    Goods goods=new Goods();
    GoodStype goodStype=new GoodStype();
    goodStype.setId(10);
    goods.setType(goodStype);
    Map <String,Object>map=new HashMap();
    Integer typeid=goods.getType().getId();
        System.out.println("typeid="+typeid);
//    goods.setName("新疆红枣");
    map.put("typeid",typeid);
    map.put("name1",goods.getName());
   List<Goods> list=goodsMapper.selectAllGoods2(map);
    for (Goods lost:list){
        System.out.println("lost="+lost);
    }
        System.out.println("list="+list);
    }
    @Test
    public void getMaxCode(){
        String maxCode=goodsMapper.getMaxCode();
       String[] a =maxCode.split("\\.");
        System.out.println(a[0]);
        System.out.println(maxCode);
    }
    @Test
    public void selectAll(){
        List<Supplier> suppliers=new ArrayList<>();
        suppliers=supplierMapper.selectAll();
        System.out.println(suppliers.size());
    }
    @Test
    public void  getTodayMaxPurchaseNumber(){
        String number=purchaseListService.getTodayMaxPurchaseNumber();
        System.out.println(number);
    }
    @Test
    public void getUserInfo(){
        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        System.out.println(u.getId());
    }
    @Test
    public void getCode() throws Exception {
        StringBuffer billCodeStr = new StringBuffer();
        billCodeStr.append("JH");
        billCodeStr.append(DateUtil.getCurrentDateStr());
        String purchaseNumber = purchaseListService.getTodayMaxPurchaseNumber();
        if (purchaseNumber != null) {
            billCodeStr.append(StringUtil.formatCode(purchaseNumber));
        } else {
            billCodeStr.append("0001");
        }
        System.out.println("billCoder" + billCodeStr);
        System.out.println("billCoder.tostring" + billCodeStr.toString());
    }
    @Test
    public void selectAllPurchaseList(){
        PurchaseList purchaseList=new PurchaseList();
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1);
        Supplier supplier=new Supplier();
        supplier.setId(1);
        purchaseList.setSupplier(supplier);
        purchaseList.setUser(userInfo);
        List<PurchaseList> list=new ArrayList<>();
        list=purchaseListMapper.selectAllPurchase2(purchaseList);
        System.out.println(purchaseList);
    }
}