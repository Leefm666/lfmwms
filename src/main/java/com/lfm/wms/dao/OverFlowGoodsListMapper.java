package com.lfm.wms.dao;

import com.lfm.wms.model.DamageListGoods;
import com.lfm.wms.model.OverflowListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/7 - 17:49
 */
public interface OverFlowGoodsListMapper {
    void insertOverFlowGoodsList(List<OverflowListGoods> overflowListGoods);
}
