package com.lfm.wms.dao;

import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.model.SaleList;
import com.lfm.wms.model.SaleListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/1 - 21:57
 */
public interface SaleListGoodsMapper {
    void insertSaleGoods(List<SaleListGoods> saleListGoodsList);
    List<SaleListGoods> selectBySaleListId(SaleList saleList);
}
