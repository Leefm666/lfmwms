package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.SaleListGoodsService;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.model.SaleList;
import com.lfm.wms.model.SaleListGoods;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/4 - 11:53
 */
@Controller
@RequestMapping("SaleListGoods")
public class SaleListGoodsController {
    @Autowired
    private SaleListGoodsService saleListGoodsService;
    @ResponseBody
    @RequestMapping("/selectBySaleListId")
    public RetResult<Object> selectByPurchaseListId(SaleList saleList, int page, int limit){
        PageInfo<SaleListGoods> pageInfo=saleListGoodsService.selectBySaleListId(saleList, page, limit);
        List<SaleListGoods> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
}
