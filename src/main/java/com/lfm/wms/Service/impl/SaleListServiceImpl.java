package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.SaleListService;
import com.lfm.wms.dao.SaleListMapper;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.SaleList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2020/1/1 - 22:05
 */
@Service
public class SaleListServiceImpl implements SaleListService {
    @Resource
    private SaleListMapper saleListMapper;

    @Override
    public String getTodayMaxSaleLisber() {
        return saleListMapper.getTodayMaxSaleLisber();
    }

    @Override
    public void insertSaleList(SaleList saleList) {
        saleListMapper.insertSaleList(saleList);
    }

    @Override
    public PageInfo<SaleList> selectAllSaleList(SaleList saleList, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<SaleList> list = saleListMapper.salectAllSaleList(saleList);
        //生成PageInfo对象
        PageInfo<SaleList> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
