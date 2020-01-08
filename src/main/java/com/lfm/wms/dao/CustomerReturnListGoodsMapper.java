package com.lfm.wms.dao;

import com.lfm.wms.model.CustomerReturnList;
import com.lfm.wms.model.CustomerReturnListGoods;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 17:17
 */
public interface CustomerReturnListGoodsMapper {
    void insertCustomerReturnListGoods(List<CustomerReturnListGoods> customerReturnListGoods);
    List<CustomerReturnListGoods> selectByCustomerReturnListId(CustomerReturnList customerReturnList);
}
