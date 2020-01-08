package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.Service.ReturnListGoodService;
import com.lfm.wms.Service.ReturnListService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/30 - 15:07
 */
@Controller
@RequestMapping("ReturnList")
public class ReturnListController {
    @Autowired
    private ReturnListService returnListService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ReturnListGoodService returnListGoodService;
    private static Integer thisreturnListId;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
   @ResponseBody
    @RequestMapping("getTodayMaxReturmListNumber")
    public String getTodayMaxReturmListNumber() throws Exception {
        StringBuffer biilCodeStr=new StringBuffer();
        biilCodeStr.append("TH");
        biilCodeStr.append(DateUtil.getCurrentDateStr()); // 拼接当前日期
        String returnNumber=returnListService.getTodayMaxReturmListNumber(); // 获取当天最大的退货单号
        if(returnNumber!=null){
            biilCodeStr.append(StringUtil.formatCode(returnNumber));
        }else{
            biilCodeStr.append("0001");
        }
        return biilCodeStr.toString();
    }

    @ResponseBody
    @RequestMapping("/insertReturnList")
    public RetResult<Object> saveReturnList(ReturnList returnList) {

        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Integer userId=u.getId();
        returnList.setUserId(userId);
        System.out.println("returnList="+returnList);
        returnListService.insertReturnList(returnList);
        thisreturnListId=returnList.getId();  /*获取插入后的ID*/
        System.out.println("purchaseList="+returnList);
        System.out.println("thisreturnListId="+thisreturnListId);
        return RetResponse.makeOKRsp();
    }


    @ResponseBody
    @RequestMapping("/insertReturnListGoods")
    public RetResult<Object>insertPurchaseListGoods(String purchaseListGoodsList ){
        System.out.println("purchaseListGoodsList"+purchaseListGoodsList);
        List<ReturnListGoods> returnListGoodsLists = JSON.parseArray(purchaseListGoodsList, ReturnListGoods.class);
        for(ReturnListGoods returnListGoods:returnListGoodsLists){
//            设置类别
            returnListGoods.setTypeId(returnListGoods.getType().getId());
            /*设置进货id*/
            returnListGoods.setReturnListId(thisreturnListId);
//            设置商品id
            returnListGoods.setGoodsId(returnListGoods.getId());
            // 修改商品库存 和 成本均价 以及上次进价
            Goods goods=  goodsService.findById(returnListGoods.getId());
            goods.setInventoryQuantity(goods.getInventoryQuantity()+returnListGoods.getNum());
            goods.setState(2);
        }
        System.out.println(returnListGoodsLists);
        returnListGoodService.insertReturnGoods(returnListGoodsLists);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/selectAllReturn")
    public RetResult<Object>selectAllReturn(ReturnList returnList,int page,int limit){
        PageInfo<ReturnList> pageInfo=returnListService.selectAllReturn(returnList, page, limit);
        List<ReturnList> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
}
