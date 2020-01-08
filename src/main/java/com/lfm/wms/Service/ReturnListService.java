package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.ReturnList;

/**
 * @author lfm
 * @date 2019/12/30 - 15:05
 */
public interface ReturnListService {
    String  getTodayMaxReturmListNumber();
    void insertReturnList(ReturnList returnList);
    PageInfo<ReturnList> selectAllReturn(ReturnList returnList, int page, int size);
}
