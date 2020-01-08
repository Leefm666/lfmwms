package com.lfm.wms.Service.impl;

import com.lfm.wms.Service.OverFlowListService;
import com.lfm.wms.dao.OverFlowListMapper;
import com.lfm.wms.model.OverflowList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lfm
 * @date 2020/1/7 - 15:59
 */@Service
public class OverFlowServiceImpl implements OverFlowListService {
     @Resource
     private OverFlowListMapper overFlowListMapper;
    @Override
    public String getTodayMaxOverFlowListNumber() {
        return overFlowListMapper.getTodayMaxOverFlowListNumber();
    }

    @Override
    public void insertOverFlowList(OverflowList overflowList) {
       overFlowListMapper.insertOverFlowList(overflowList);
    }
}
