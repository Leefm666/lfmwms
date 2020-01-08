package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.Service.OverFlowListService;
import com.lfm.wms.Service.OverflowListGoodsService;
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
 * @date 2020/1/7 - 17:00
 */
@Controller
@RequestMapping("OverFlowList")
public class OverFlowListController {
    private static Integer thisOverFlowListId;
    @Autowired
    private OverFlowListService overFlowListService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OverflowListGoodsService overflowListGoodsService;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @ResponseBody
    @RequestMapping("/getOverFloeListNumber")
    public String getOverFloeListNumber() throws Exception {
        StringBuffer billCodeStr = new StringBuffer();
        billCodeStr.append("BY");
        billCodeStr.append(DateUtil.getCurrentDateStr());
        String purchaseNumber = overFlowListService.getTodayMaxOverFlowListNumber();
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
    @RequestMapping("/insertOverFlowList")
    public RetResult<Object> insertOverFlowList(OverflowList overflowList) {

        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Integer userId=u.getId();
        overflowList.setUserId(userId);
        overFlowListService.insertOverFlowList(overflowList);
        thisOverFlowListId=overflowList.getId();  /*获取插入后的ID*/
        System.out.println("overflowList="+overflowList);
        System.out.println("thisOverFlowListId="+thisOverFlowListId);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/insertOverFlowListGoods")
    public RetResult<Object>insertOverFlowListGoods(String overFlowListGoodsList){
        System.out.println("overFlowListGoodsList"+overFlowListGoodsList);
        List<OverflowListGoods> overflowListGoodsLists = JSON.parseArray(overFlowListGoodsList, OverflowListGoods.class);
        for(OverflowListGoods overFlowListGoods:overflowListGoodsLists){
//            设置类别
            overFlowListGoods.setTypeId(overFlowListGoods.getType().getId());
//            设置进货id
            overFlowListGoods.setOverflowListId(thisOverFlowListId);
//            设置商品id
            overFlowListGoods.setGoodsId( overFlowListGoods.getId());
            // 修改商品库存 和 成本均价 以及上次进价
            Goods goods=  goodsService.findById( overFlowListGoods.getId());
            goods.setInventoryQuantity(goods.getInventoryQuantity()-overFlowListGoods.getNum());
//            goods.setLastPurchasingPrice(purchaseListGoods.getPrice());
            goods.setState(2);
        }
        System.out.println(overflowListGoodsLists);
        overflowListGoodsService.insertOverFlowGoodsList(overflowListGoodsLists);
        return RetResponse.makeOKRsp();
    }
}
