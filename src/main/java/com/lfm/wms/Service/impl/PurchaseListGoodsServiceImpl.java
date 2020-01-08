package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.PurchaseListGoodsService;
import com.lfm.wms.dao.PurchaseListGoodsMapper;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/29 - 18:48
 */
@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {
    @Resource
    private PurchaseListGoodsMapper purchaseListGoodsMapper;
    @Override
    public void insertPurchaseGoods(List<PurchaseListGoods> purchaseListGoodsList) {
        purchaseListGoodsMapper.insertPurchaseGoods(purchaseListGoodsList);
    }

    @Override
    public PageInfo<PurchaseListGoods> selectByPurchaseListId(PurchaseList purchaseList, int page, int size) {
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<PurchaseListGoods> list = purchaseListGoodsMapper.selectByPurchaseListId(purchaseList);
        //生成PageInfo对象
        PageInfo<PurchaseListGoods> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
