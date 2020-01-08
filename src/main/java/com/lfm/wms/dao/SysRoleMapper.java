package com.lfm.wms.dao;

import com.lfm.wms.model.BindUser;
import com.lfm.wms.model.SysRole;
import com.lfm.wms.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/11/30 - 10:58
 */
public interface SysRoleMapper {
    List<SysRole> selectAllRole(SysRole sysRole);
    Integer addRole(SysRole sysRole);
    SysRole selectByRoleName(String RoleName);
    int deleteRole(Integer roleId);
    void updateRole(SysRole sysRole);
    List<String> selectRoleUser(SysRole sysRole);
    List<UserInfo> selectRoleUser1(SysRole sysRole);
    void bindUser(@Param("u_id") Integer u_id, @Param("s_id") Integer s_id);
    void bindUser1(List<BindUser> bindUsers);
    void deleteBindUser(@Param("u_id") Integer u_id, @Param("s_id") Integer s_id);
    List<UserInfo> selectNoBindRoleUser(SysRole sysRole);
    //        根据founder的id取出roleValue的值
    String getRoleValue(Integer roleId);
}
