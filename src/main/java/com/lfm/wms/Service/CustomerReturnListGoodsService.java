package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.CustomerReturnList;
import com.lfm.wms.model.CustomerReturnListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 17:29
 */
public interface CustomerReturnListGoodsService {
    void insertCustomerReturnListGoods(List<CustomerReturnListGoods> customerReturnListGoods);
    PageInfo<CustomerReturnListGoods>selectByCustomerReturnListId(CustomerReturnList customerReturnList,int page,int size);
}
