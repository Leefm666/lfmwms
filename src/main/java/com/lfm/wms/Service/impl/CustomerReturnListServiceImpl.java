package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.CustomerReturnListService;
import com.lfm.wms.dao.CustomerReturnListMapper;
import com.lfm.wms.model.CustomerReturnList;
import com.lfm.wms.model.PurchaseList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 16:05
 */
@Service
public class CustomerReturnListServiceImpl implements CustomerReturnListService {
    @Resource
    private CustomerReturnListMapper customerReturnListMapper;
    @Override
    public String getTodayMaxCustomerReturnNumber() {
        return customerReturnListMapper.getTodayMaxCustomerReturnNumber();
    }

    @Override
    public void insertCustomerReturnList(CustomerReturnList customerReturnList){
        customerReturnListMapper.insertCustomerReturnList(customerReturnList);
    }

    @Override
    public PageInfo<CustomerReturnList> selectAllCustomerReturnList(CustomerReturnList customerReturnList, int page, int size) {
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<CustomerReturnList> list = customerReturnListMapper.selectAllCustomerReturnList(customerReturnList);
        //生成PageInfo对象
        PageInfo<CustomerReturnList> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
