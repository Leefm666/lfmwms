package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.SaleListGoodsService;
import com.lfm.wms.Service.SaleListService;
import com.lfm.wms.dao.SaleListGoodsMapper;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.model.SaleList;
import com.lfm.wms.model.SaleListGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 9:54
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {
    @Resource
    private SaleListGoodsMapper saleListGoodsMapper;
    @Override
    public void insertSaleGoods(List<SaleListGoods> saleListGoodsList) {
        saleListGoodsMapper.insertSaleGoods(saleListGoodsList);
    }

    @Override
    public PageInfo<SaleListGoods> selectBySaleListId(SaleList saleList, int page, int size) {
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<SaleListGoods> list = saleListGoodsMapper.selectBySaleListId(saleList);
        //生成PageInfo对象
        PageInfo<SaleListGoods> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


}
