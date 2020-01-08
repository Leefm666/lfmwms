package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.Action;
import com.lfm.wms.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/11 - 10:22
 */
public interface ActionService {
    PageInfo<Action> selectAllAction(SysRole sysRole,int page, int size);
    void addAction(Map<String,Object> map);
    PageInfo<Action> selectNoAction(SysRole sysRole,int page, int size);
    void updateActionmodifie(@Param("roleid") String roleid, @Param("actionid") Integer actionid);
    void deleteAction(Action action);
}
