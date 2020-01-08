package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.Service.SaleListGoodsService;
import com.lfm.wms.Service.SaleListService;
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
 * @date 2020/1/1 - 22:26
 */
@Controller
@RequestMapping("SaleList")
public class SaleListController {
    private static Integer thisSaleListId;
    @Autowired
    private SaleListService saleListService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SaleListGoodsService saleListGoodsService;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @ResponseBody
    @RequestMapping("/getSaleListNumber")
    public String getSaleListNumber() throws Exception {
        StringBuffer billCodeStr = new StringBuffer();
        billCodeStr.append("XS");
        billCodeStr.append(DateUtil.getCurrentDateStr());
        String purchaseNumber = saleListService.getTodayMaxSaleLisber();
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
    @RequestMapping("/insertSaleList")
    public RetResult<Object> saveSaleList(SaleList saleList) {

        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Integer userId=u.getId();
        saleList.setUserId(userId);

        saleListService.insertSaleList(saleList);
        thisSaleListId=saleList.getId();  /*获取插入后的ID*/
        System.out.println("saleList="+saleList);
        System.out.println("thisSaleListId="+thisSaleListId);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/insertSaleListGoods")
    public RetResult<Object>insertPurchaseListGoods(String saleListGoodsList ){
        System.out.println("saleListGoodsList"+saleListGoodsList);
        List<SaleListGoods> saleListGoodsLists = JSON.parseArray(saleListGoodsList, SaleListGoods.class);
        for(SaleListGoods saleListGoods:saleListGoodsLists){
//            设置类别
            saleListGoods.setTypeId(saleListGoods.getType().getId());
            /*设置进货id*/
            saleListGoods.setSaleListId(thisSaleListId);
//            设置商品id
            saleListGoods.setGoodsId(saleListGoods.getId());
            // 修改商品库存 和 成本均价 以及上次进价
            Goods goods=  goodsService.findById(saleListGoods.getId());
            goods.setInventoryQuantity(goods.getInventoryQuantity()-saleListGoods.getNum());
//            goods.setLastPurchasingPrice(saleListGoods.getPrice());
            goods.setState(2);
        }

        System.out.println(saleListGoodsLists);
       saleListGoodsService.insertSaleGoods(saleListGoodsLists);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/selectAllSaleList")
    public RetResult<Object>selectAllSaleList(SaleList saleList,int page,int limit){
        PageInfo<SaleList> pageInfo=saleListService.selectAllSaleList(saleList, page, limit);
        List<SaleList> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
}
