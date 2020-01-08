package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.Service.PurchaseListGoodsService;
import com.lfm.wms.Service.PurchaseListService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author lfm
 * @date 2019/12/25 - 0:05
 */
@Controller
@RequestMapping("PurchaseList")
public class PurchaseListController {
    @Autowired
    private PurchaseListService purchaseListService;
    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;
    @Autowired
    private GoodsService goodsService;
    private static Integer thispurchaseListId;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @ResponseBody
    @RequestMapping("/getPurchaseNumber")
    public String getPurchaseNumber() throws Exception {
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
        return billCodeStr.toString();
    }

    @ResponseBody
    @RequestMapping("/insertPurchaseList")
    public RetResult<Object> savePurchaseList(PurchaseList purchaseList) {

        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Integer userId=u.getId();
         purchaseList.setUserId(userId);

       purchaseListService.insertPurchaseList(purchaseList);
       thispurchaseListId=purchaseList.getId();  /*获取插入后的ID*/
        System.out.println("purchaseList="+purchaseList);
        System.out.println("thispurchaseListId="+thispurchaseListId);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @PostMapping("/getNowUser")
    public UserInfo getNowUser() {
        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        System.out.println(u.getId());
        return u;
    }
    @ResponseBody
        @RequestMapping("/insertPurchaseListGoods")
        public RetResult<Object>insertPurchaseListGoods(String purchaseListGoodsList ){
            System.out.println("purchaseListGoodsList"+purchaseListGoodsList);
            List<PurchaseListGoods> purchaseListGoodsLists = JSON.parseArray(purchaseListGoodsList, PurchaseListGoods.class);
            for(PurchaseListGoods purchaseListGoods:purchaseListGoodsLists){
//            设置类别
                purchaseListGoods.setTypeId(purchaseListGoods.getType().getId());
                /*设置进货id*/
                purchaseListGoods.setPurchaseListId(thispurchaseListId);
//            设置商品id
                purchaseListGoods.setGoodsId(purchaseListGoods.getId());
                // 修改商品库存 和 成本均价 以及上次进价
                Goods goods=  goodsService.findById(purchaseListGoods.getId());
                goods.setInventoryQuantity(goods.getInventoryQuantity()+purchaseListGoods.getNum());
                goods.setLastPurchasingPrice(purchaseListGoods.getPrice());
                goods.setState(2);
            }
        System.out.println(purchaseListGoodsLists);
        purchaseListGoodsService.insertPurchaseGoods(purchaseListGoodsLists);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/selectAllPurchaseList")
    public RetResult<Object>selectAllPurchaseList(PurchaseList purchaseList,int page,int limit){
        PageInfo<PurchaseList> pageInfo=purchaseListService.selectAllPurchase(purchaseList, page, limit);
        List<PurchaseList> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("/selectAllPurchaseList2")
    public RetResult<Object>selectAllPurchaseList2(PurchaseList purchaseList,int page,int limit){
        PageInfo<PurchaseList> pageInfo=purchaseListService.selectAllPurchase2(purchaseList, page, limit);
        List<PurchaseList> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
}
