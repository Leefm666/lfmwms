package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.SaleList;

/**
 * @author lfm
 * @date 2020/1/1 - 22:04
 */
public interface SaleListService {
    String  getTodayMaxSaleLisber();
    void insertSaleList(SaleList saleList);
    PageInfo<SaleList> selectAllSaleList(SaleList saleList, int page, int size);
}
