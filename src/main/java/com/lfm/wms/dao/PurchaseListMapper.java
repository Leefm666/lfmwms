package com.lfm.wms.dao;

import com.lfm.wms.model.PurchaseList;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/24 - 22:27
 */
public interface PurchaseListMapper {
   String  getTodayMaxPurchaseNumber();
   void insertPurchaseList(PurchaseList purchaseList);
   List<PurchaseList>selectAllPurchase(PurchaseList purchaseList);
   List<PurchaseList>selectAllPurchase2(PurchaseList purchaseList);
}
