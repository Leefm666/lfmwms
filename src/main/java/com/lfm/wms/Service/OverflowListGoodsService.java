package com.lfm.wms.Service;

import com.lfm.wms.model.OverflowListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/7 - 21:06
 */
public interface OverflowListGoodsService {
    void insertOverFlowGoodsList(List<OverflowListGoods> overflowListGoods);
}
