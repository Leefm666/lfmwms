package com.lfm.wms.dao;


import com.lfm.wms.model.DamageList;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.SaleList;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/1 - 21:47
 */
public interface SaleListMapper {
    String  getTodayMaxSaleLisber();
    void insertSaleList(SaleList saleList);
    List<SaleList> salectAllSaleList(SaleList saleList);

}
