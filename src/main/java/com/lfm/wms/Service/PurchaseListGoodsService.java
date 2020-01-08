package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/29 - 18:47
 */
public interface PurchaseListGoodsService {
    void insertPurchaseGoods(List<PurchaseListGoods> purchaseListGoodsList);
    PageInfo<PurchaseListGoods> selectByPurchaseListId(PurchaseList purchaseList, int page, int size);
}
