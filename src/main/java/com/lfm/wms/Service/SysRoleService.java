package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.BindUser;
import com.lfm.wms.model.SysRole;
import com.lfm.wms.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/11/30 - 15:57
 */
public interface SysRoleService {
    PageInfo<SysRole> getAll(SysRole sysRole, int page, int size);
    Integer addRole(SysRole sysRole);
    SysRole selectByRoleName(String RoleName);
    int deleteRole(Integer roleId);
    void updateRole(SysRole sysRole);
    List<String> selectRoleUser(SysRole sysRole);
//    List<UserInfo> selectRoleUser1(SysRole sysRole);
    PageInfo<UserInfo>selectRoleUser1(SysRole sysRole, int page, int size);
    void bindUser(Integer u_id,Integer s_id);
    void bindUser1(List<BindUser> bindUsers);
    void deleteBindUser(@Param("u_id") Integer u_id, @Param("s_id") Integer s_id);
    PageInfo<UserInfo> selectNoBindRoleUser(SysRole sysRole,int page, int size);
    String getRoleValue(Integer roleId);
}
