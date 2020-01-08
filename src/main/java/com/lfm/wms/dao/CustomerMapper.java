package com.lfm.wms.dao;

import com.lfm.wms.model.Customer;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 19:24
 */
public interface CustomerMapper {
    List<Customer>selectAllCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void  addCustomer(Customer customer);
    List<Customer>selectAll();
}
