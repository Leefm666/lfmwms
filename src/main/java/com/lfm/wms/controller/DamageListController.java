package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.lfm.wms.Service.DamageListGoodsService;
import com.lfm.wms.Service.DamageListService;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.core.utils.DateUtil;
import com.lfm.wms.core.utils.StringUtil;
import com.lfm.wms.dao.DamageListMapper;
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
 * @date 2020/1/5 - 10:33
 */
@Controller
@RequestMapping("DamageList")
public class DamageListController {
    private static Integer thisDamageListId;
    @Autowired
    private DamageListService damageListService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private DamageListGoodsService damageListGoodsService;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @ResponseBody
    @RequestMapping("/getTodayMaxDamageListNumber")
    public String getTodayMaxDamageListNumber() throws Exception {
        StringBuffer billCodeStr = new StringBuffer();
        billCodeStr.append("BS");
        billCodeStr.append(DateUtil.getCurrentDateStr());
        String purchaseNumber = damageListService.getTodayMaxDamageListNumber();
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
    public RetResult<Object> savePurchaseList(DamageList damageList) {

        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Integer userId=u.getId();
        damageList.setUserId(userId);
        damageListService.insertDamageList(damageList);
        thisDamageListId=damageList.getId();  /*获取插入后的ID*/
        System.out.println("damageList="+damageList);
        System.out.println("thisDamageListId="+thisDamageListId);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/insertDamageGoods")
    public RetResult<Object>insertDamageGoods(String damageListGoodsList ){
        System.out.println("damageListGoodsList"+damageListGoodsList);
        List<DamageListGoods> damageListGoodsLists = JSON.parseArray(damageListGoodsList, DamageListGoods.class);
        for(DamageListGoods damageListGoods:damageListGoodsLists){
//            设置类别
            damageListGoods.setTypeId(damageListGoods.getType().getId());
//            设置进货id
            damageListGoods.setDamageListId(thisDamageListId);
//            设置商品id
            damageListGoods.setGoodsId(damageListGoods.getId());
            // 修改商品库存 和 成本均价 以及上次进价
            Goods goods=  goodsService.findById(damageListGoods.getId());
            goods.setInventoryQuantity(goods.getInventoryQuantity()-damageListGoods.getNum());
//            goods.setLastPurchasingPrice(purchaseListGoods.getPrice());
            goods.setState(2);
        }
        System.out.println(damageListGoodsLists);
        damageListGoodsService.insertDamageGoods(damageListGoodsLists);
        return RetResponse.makeOKRsp();
    }
}
