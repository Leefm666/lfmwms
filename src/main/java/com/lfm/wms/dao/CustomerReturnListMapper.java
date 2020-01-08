package com.lfm.wms.dao;

import com.lfm.wms.model.CustomerReturnList;
import com.lfm.wms.model.PurchaseList;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 15:51
 */
public interface CustomerReturnListMapper {
    String  getTodayMaxCustomerReturnNumber();
    void insertCustomerReturnList(CustomerReturnList customerReturnList);
    List<CustomerReturnList> selectAllCustomerReturnList(CustomerReturnList customerReturnList);
}
