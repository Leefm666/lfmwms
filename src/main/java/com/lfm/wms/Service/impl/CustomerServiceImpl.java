package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.CustomerService;
import com.lfm.wms.dao.CustomerMapper;
import com.lfm.wms.model.Customer;
import com.lfm.wms.model.Supplier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 19:39
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Override
    public PageInfo<Customer> selectAllCustomer(Customer customer, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<Customer> list =customerMapper.selectAllCustomer(customer);
        //生成PageInfo对象
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public List<Customer> selectAll() {
        return customerMapper.selectAll();
    }
}
