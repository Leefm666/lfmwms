package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.ReturnListGoodService;
import com.lfm.wms.Service.ReturnListService;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.model.ReturnList;
import com.lfm.wms.model.ReturnListGoods;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/30 - 17:47
 */
@Controller
@RequestMapping("ReturnListGoods")
public class ReturnListGoodsController {
    @Autowired
    private ReturnListGoodService returnListGoodsService;
    @ResponseBody
    @RequestMapping("/selectByReturnListId")
    public RetResult<Object> selectByReturnListId(ReturnList returnList, int page, int limit){
        PageInfo<ReturnListGoods> pageInfo=returnListGoodsService.selectByReturnListId(returnList, page, limit);
        List<ReturnListGoods> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
}
