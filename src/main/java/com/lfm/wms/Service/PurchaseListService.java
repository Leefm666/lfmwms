package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.SysRole;

/**
 * @author lfm
 * @date 2019/12/25 - 0:03
 */
public interface PurchaseListService {
    String  getTodayMaxPurchaseNumber();
    void insertPurchaseList(PurchaseList purchaseList);
    PageInfo<PurchaseList> selectAllPurchase(PurchaseList purchaseList, int page, int size);
    PageInfo<PurchaseList> selectAllPurchase2(PurchaseList purchaseList, int page, int size);
}
