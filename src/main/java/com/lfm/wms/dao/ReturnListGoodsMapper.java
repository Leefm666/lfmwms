package com.lfm.wms.dao;

import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.model.ReturnList;
import com.lfm.wms.model.ReturnListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/30 - 17:15
 */
public interface ReturnListGoodsMapper {
    void insertReturnGoods(List<ReturnListGoods> returnListGoodsList);
    List<ReturnListGoods> selectByReturnListId(ReturnList returnList);
}
