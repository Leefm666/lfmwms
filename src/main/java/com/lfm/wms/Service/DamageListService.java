package com.lfm.wms.Service;

import com.lfm.wms.model.DamageList;

/**
 * @author lfm
 * @date 2020/1/5 - 10:31
 */
public interface DamageListService {
    String  getTodayMaxDamageListNumber();
    void insertDamageList(DamageList damageList);
}
