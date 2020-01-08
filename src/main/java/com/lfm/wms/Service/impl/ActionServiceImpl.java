package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.ActionService;
import com.lfm.wms.dao.ActionMapper;
import com.lfm.wms.model.Action;
import com.lfm.wms.model.SysRole;
import com.lfm.wms.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/11 - 10:24
 */
@Service
public class ActionServiceImpl implements ActionService {
    @Resource
    private ActionMapper actionMapper;
    @Override
    public PageInfo<Action> selectAllAction(SysRole sysRole,int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<Action> list = actionMapper.selectAllAction(sysRole);
        //生成PageInfo对象
        PageInfo<Action> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void addAction(Map<String, Object> map) {
        actionMapper.addAction(map);
    }

    @Override
    public PageInfo<Action> selectNoAction(SysRole sysRole, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<Action> list = actionMapper.selectNoAction(sysRole);
        //生成PageInfo对象
        PageInfo<Action> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void updateActionmodifie(String roleid, Integer actionid) {
        actionMapper.updateActionmodifie(roleid,actionid);
    }

    @Override
    public void deleteAction(Action action) {
        actionMapper.deleteAction(action);
    }


}
