package com.lfm.wms.dao;

import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.ReturnList;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/30 - 14:10
 */
public interface ReturnListMapper {
    String  getTodayMaxReturmListNumber();
    void insertReturnList(ReturnList returnList);
    List<ReturnList> selectAllReturn(ReturnList returnList);
}
