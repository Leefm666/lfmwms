package com.lfm.wms.Service.impl;

import com.lfm.wms.Service.DamageListService;
import com.lfm.wms.dao.DamageListMapper;
import com.lfm.wms.model.DamageList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lfm
 * @date 2020/1/5 - 10:31
 */
@Service
public class DamageListServiceImpl implements DamageListService {
    @Resource
    private DamageListMapper damageListMapper;
    @Override
    public String getTodayMaxDamageListNumber() {
        return damageListMapper.getTodayMaxDamageListNumber();
    }

    @Override
    public void insertDamageList(DamageList damageList) {
        damageListMapper.insertDamageList(damageList);
    }
}
