package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.PurchaseListService;
import com.lfm.wms.dao.PurchaseListMapper;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.SysRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/25 - 0:03
 */
@Service
public class PurchaseListServiceImpl implements PurchaseListService {
    @Resource
    private PurchaseListMapper purchaseListMapper;
    @Override
    public String getTodayMaxPurchaseNumber() {
        return purchaseListMapper.getTodayMaxPurchaseNumber();
    }

    @Override
    public void insertPurchaseList(PurchaseList purchaseList) {
        purchaseListMapper.insertPurchaseList(purchaseList);
    }

    @Override
    public PageInfo<PurchaseList> selectAllPurchase(PurchaseList purchaseList, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<PurchaseList> list = purchaseListMapper.selectAllPurchase(purchaseList);
        //生成PageInfo对象
        PageInfo<PurchaseList> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<PurchaseList> selectAllPurchase2(PurchaseList purchaseList, int page, int size) {
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<PurchaseList> list = purchaseListMapper.selectAllPurchase2(purchaseList);
        //生成PageInfo对象
        PageInfo<PurchaseList> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
