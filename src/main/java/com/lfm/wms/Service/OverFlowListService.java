package com.lfm.wms.Service;

import com.lfm.wms.model.OverflowList;

/**
 * @author lfm
 * @date 2020/1/7 - 15:57
 */
public interface OverFlowListService {
    String  getTodayMaxOverFlowListNumber();
    void insertOverFlowList(OverflowList overflowList);
}
