package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.Customer;
import com.lfm.wms.model.Supplier;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 19:37
 */
public interface CustomerService {
    PageInfo<Customer> selectAllCustomer(Customer customer, int page, int size);
    void updateCustomer(Customer customer);
    void  addCustomer(Customer customer);
    List<Customer> selectAll();
}
