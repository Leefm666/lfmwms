package com.lfm.wms.dao;

import com.lfm.wms.model.Action;
import com.lfm.wms.model.SysPermissionInit;
import com.lfm.wms.model.SysRole;
import com.lfm.wms.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/11 - 10:12
 */
public interface ActionMapper {
    List<Action> selectAllAction(SysRole sysRole);
    void addAction(Map<String,Object> map);
    List<Action> selectNoAction(SysRole sysRole);
    void updateActionmodifie(@Param("roleid") String roleid, @Param("actionid") Integer actionid);
    void deleteAction(Action action);

}
