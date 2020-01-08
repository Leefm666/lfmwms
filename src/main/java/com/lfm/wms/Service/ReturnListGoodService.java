package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.model.ReturnList;
import com.lfm.wms.model.ReturnListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/30 - 17:37
 */
public interface ReturnListGoodService {
    void insertReturnGoods(List<ReturnListGoods> returnListGoodsList);
    PageInfo<ReturnListGoods> selectByReturnListId(ReturnList returnListGoods, int page, int size);
}
