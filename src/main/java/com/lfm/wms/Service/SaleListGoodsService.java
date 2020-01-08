package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.SaleList;
import com.lfm.wms.model.SaleListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/3 - 9:53
 */
public interface SaleListGoodsService {
    void insertSaleGoods(List<SaleListGoods> saleListGoodsList);
    PageInfo<SaleListGoods> selectBySaleListId(SaleList saleList,int page,int size);
}
