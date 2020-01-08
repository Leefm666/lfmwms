package com.lfm.wms.dao;

import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/24 - 23:40
 */
public interface PurchaseListGoodsMapper {
    void insertPurchaseGoods(List<PurchaseListGoods> purchaseListGoodsList);
   List<PurchaseListGoods> selectByPurchaseListId(PurchaseList purchaseList);
}
