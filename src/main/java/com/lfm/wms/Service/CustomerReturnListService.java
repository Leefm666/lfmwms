package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.CustomerReturnList;

/**
 * @author lfm
 * @date 2020/1/3 - 16:04
 */
public interface CustomerReturnListService {
    String  getTodayMaxCustomerReturnNumber();
    void insertCustomerReturnList(CustomerReturnList customerReturnList);
    PageInfo<CustomerReturnList> selectAllCustomerReturnList(CustomerReturnList customerReturnList,int page,int size);
}
