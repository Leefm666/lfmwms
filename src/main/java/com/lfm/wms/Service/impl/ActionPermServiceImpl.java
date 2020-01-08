package com.lfm.wms.Service.impl;

import com.lfm.wms.Service.ActionPermService;
import com.lfm.wms.dao.ActionPermMapper;
import com.lfm.wms.model.Action;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lfm
 * @date 2019/12/17 - 9:59
 */
@Service
public class ActionPermServiceImpl implements ActionPermService {
    @Resource
    private ActionPermMapper actionPermMapper;
    @Override
    public void insertpermroid(String actionid, String perminitid) {
        actionPermMapper.insertpermroid(actionid,perminitid);
    }

    @Override
    public String selectPerInitId(Action action) {
        return actionPermMapper.selectPerInitId(action);
    }

    @Override
    public void deleteActionPerm(Action action) {
        actionPermMapper.deleteActionPerm(action);
    }
}
