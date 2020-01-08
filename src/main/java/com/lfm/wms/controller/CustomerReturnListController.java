package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.CustomerReturnListGoodsService;
import com.lfm.wms.Service.CustomerReturnListService;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.core.utils.DateUtil;
import com.lfm.wms.core.utils.StringUtil;
import com.lfm.wms.model.*;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 16:07
 */
@Controller
@RequestMapping("CustomerReturnList")
public class CustomerReturnListController {
    private static Integer thisCustomerReturnListId;
    @Autowired
    private CustomerReturnListService customerReturnListService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CustomerReturnListGoodsService customerReturnListGoodsService;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @ResponseBody
    @RequestMapping("/getTodayMaxCustomerReturnNumber")
    String  getTodayMaxCustomerReturnNumber() throws Exception {
        StringBuffer billCodeStr = new StringBuffer();
        billCodeStr.append("XT");
        billCodeStr.append(DateUtil.getCurrentDateStr());
        String purchaseNumber = customerReturnListService.getTodayMaxCustomerReturnNumber();
        if (purchaseNumber != null) {
            billCodeStr.append(StringUtil.formatCode(purchaseNumber));
        } else {
            billCodeStr.append("0001");
        }
        System.out.println("billCoder" + billCodeStr);
        System.out.println("billCoder.tostring" + billCodeStr.toString());
        return billCodeStr.toString();
    }
    @ResponseBody
    @RequestMapping("insertCustomerReturnList")
    public RetResult<Object> saveCustomerReturnList(CustomerReturnList customerReturnList) {

        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Integer userId=u.getId();
        customerReturnList.setUserId(userId);

        customerReturnListService.insertCustomerReturnList(customerReturnList);
        thisCustomerReturnListId=customerReturnList.getId();  /*获取插入后的ID*/
        System.out.println("customerReturnList="+customerReturnList);
        System.out.println("thisCustomerReturnListId="+thisCustomerReturnListId);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/insertCustomerReturnListGoods")
    public RetResult<Object>insertCustomerReturnListGoods(String customerReturnListGoodsList ){
        System.out.println("customerReturnListGoodsList"+customerReturnListGoodsList);
        List<CustomerReturnListGoods> customerReturnListGoodsLists = JSON.parseArray(customerReturnListGoodsList, CustomerReturnListGoods.class);
        for(CustomerReturnListGoods customerReturnListGoods:customerReturnListGoodsLists){
//            设置类别
            customerReturnListGoods.setTypeId(customerReturnListGoods.getType().getId());
//            设置进货id
            customerReturnListGoods.setCustomerReturnListId(thisCustomerReturnListId);
//            设置商品id
            customerReturnListGoods.setGoodsId(customerReturnListGoods.getId());
            // 修改商品库存 和 成本均价 以及上次进价
            Goods goods=  goodsService.findById(customerReturnListGoods.getId());
            goods.setInventoryQuantity(goods.getInventoryQuantity()+customerReturnListGoods.getNum());
//            goods.setLastPurchasingPrice(purchaseListGoods.getPrice());
            goods.setState(2);
        }
        System.out.println(customerReturnListGoodsLists);
        customerReturnListGoodsService.insertCustomerReturnListGoods(customerReturnListGoodsLists);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/selectAllCustomerReturnList")
    public RetResult<Object>selectAllCustomerReturnList(CustomerReturnList customerReturnList,int page,int limit){
        PageInfo<CustomerReturnList> pageInfo=customerReturnListService.selectAllCustomerReturnList(customerReturnList, page, limit);
        List<CustomerReturnList> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
}
