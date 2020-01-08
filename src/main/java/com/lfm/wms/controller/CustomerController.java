package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.CustomerService;
import com.lfm.wms.model.Customer;
import com.lfm.wms.model.Supplier;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 19:42
 */
@Controller
@RequestMapping("Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @ResponseBody
    @RequestMapping("selectAllCustomer")
    public RetResult<List<Customer>>selectAllCustomer(Customer customer ,int page,int limit){
        PageInfo<Customer> pageInfo=customerService.selectAllCustomer(customer,page,limit);
        List<Customer> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("updateCustomer")
    public  RetResult<Object>updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("addCustomer")
    public RetResult<Object>addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("selectAll")
    public List<Customer> selectAllCustomer(){
        return customerService.selectAll();
    }
}
