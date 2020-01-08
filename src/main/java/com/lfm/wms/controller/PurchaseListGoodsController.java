package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lfm.wms.Service.PurchaseListGoodsService;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/29 - 18:51
 */
@Controller
@RequestMapping("PurchaseListGoods")
public class PurchaseListGoodsController {
    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;
    @ResponseBody
    @RequestMapping("/selectByPurchaseListId")
    public RetResult<Object>selectByPurchaseListId(PurchaseList purchaseList, int page, int limit){
        PageInfo<PurchaseListGoods> pageInfo=purchaseListGoodsService.selectByPurchaseListId(purchaseList, page, limit);
        List<PurchaseListGoods> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }

}
