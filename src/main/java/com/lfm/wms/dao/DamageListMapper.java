package com.lfm.wms.dao;

import com.lfm.wms.model.DamageList;

/**
 * @author lfm
 * @date 2020/1/4 - 17:59
 */
public interface DamageListMapper {
    String  getTodayMaxDamageListNumber();
    void insertDamageList(DamageList damageList);
}
