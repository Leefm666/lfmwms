package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.CustomerReturnListGoodsService;
import com.lfm.wms.dao.CustomerReturnListGoodsMapper;
import com.lfm.wms.model.CustomerReturnList;
import com.lfm.wms.model.CustomerReturnListGoods;
import com.lfm.wms.model.PurchaseListGoods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 17:30
 */
@Service
public class CustomerReturnListGoodsServiceImpl implements CustomerReturnListGoodsService {
    @Resource
    private CustomerReturnListGoodsMapper customerReturnListGoodsMapper;
    @Override
    public void insertCustomerReturnListGoods(List<CustomerReturnListGoods> customerReturnListGoods) {
        customerReturnListGoodsMapper.insertCustomerReturnListGoods(customerReturnListGoods);
    }

    @Override
    public PageInfo<CustomerReturnListGoods> selectByCustomerReturnListId(CustomerReturnList customerReturnList, int page, int size) {
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<CustomerReturnListGoods> list = customerReturnListGoodsMapper.selectByCustomerReturnListId(customerReturnList);
        //生成PageInfo对象
        PageInfo<CustomerReturnListGoods> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
