package com.lfm.wms.dao;

import com.lfm.wms.model.OverflowList;
import com.lfm.wms.model.PurchaseList;

/**
 * @author lfm
 * @date 2020/1/6 - 10:43
 */
public interface OverFlowListMapper {
    String  getTodayMaxOverFlowListNumber();
    void insertOverFlowList(OverflowList overflowList);
}
