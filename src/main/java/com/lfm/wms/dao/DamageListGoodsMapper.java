package com.lfm.wms.dao;

import com.lfm.wms.model.DamageListGoods;
import com.lfm.wms.model.PurchaseListGoods;

import java.util.List;

/**
 * @author lfm
 * @date 2020/1/4 - 21:53
 */
public interface DamageListGoodsMapper {
    void insertDamageGoods(List<DamageListGoods> damageListGoodsList);
}
