package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.CustomerReturnListGoodsService;
import com.lfm.wms.model.CustomerReturnList;
import com.lfm.wms.model.CustomerReturnListGoods;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 17:33
 */
@Controller
@RequestMapping("CustomerReturnListGoods")
public class CustomerReturnListGoodsController {
    @Autowired
    private CustomerReturnListGoodsService customerReturnListGoodsService;
    @ResponseBody
    @RequestMapping("/selectByCustomerReturnListId")
    public RetResult<Object> selectByCustomerReturnListId(CustomerReturnList customerReturnList, int page, int limit){
        PageInfo<CustomerReturnListGoods> pageInfo=customerReturnListGoodsService.selectByCustomerReturnListId(customerReturnList, page, limit);
        List<CustomerReturnListGoods> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
}
