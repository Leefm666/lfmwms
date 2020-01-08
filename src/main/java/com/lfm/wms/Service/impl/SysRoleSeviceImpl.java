package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.SysRoleService;
import com.lfm.wms.dao.SysRoleMapper;
import com.lfm.wms.model.BindUser;
import com.lfm.wms.model.SysRole;
import com.lfm.wms.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/11/30 - 15:59
 */
@Service
public class SysRoleSeviceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Override
    public PageInfo<SysRole> getAll(SysRole sysRole, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<SysRole> list = sysRoleMapper.selectAllRole(sysRole);
        //生成PageInfo对象
        PageInfo<SysRole> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer addRole(SysRole sysRole) {
        Integer total=sysRoleMapper.addRole(sysRole);
        return total;
    }

    @Override
    public SysRole selectByRoleName(String RoleName) {
        return sysRoleMapper.selectByRoleName(RoleName);
    }

    @Override
    public int deleteRole(Integer roleId) {
        int  total=sysRoleMapper.deleteRole(roleId);
        return total;
    }

    @Override
    public void updateRole(SysRole sysRole) {
        sysRoleMapper.updateRole(sysRole);
    }

    @Override
    public List<String> selectRoleUser(SysRole sysRole) {
        return sysRoleMapper.selectRoleUser(sysRole);
    }

    @Override
    public PageInfo<UserInfo> selectRoleUser1(SysRole sysRole ,int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<UserInfo> list = sysRoleMapper.selectRoleUser1(sysRole);
        //生成PageInfo对象
        PageInfo<UserInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void bindUser(Integer u_id, Integer s_id) {
        sysRoleMapper.bindUser(u_id,s_id);
    }

    @Override
    public void bindUser1(List<BindUser> bindUsers) {
        sysRoleMapper.bindUser1(bindUsers);
    }

    @Override
    public void deleteBindUser(Integer u_id, Integer s_id) {
        sysRoleMapper.deleteBindUser(u_id,s_id);
    }

    @Override
    public PageInfo<UserInfo> selectNoBindRoleUser(SysRole sysRole, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<UserInfo> list = sysRoleMapper.selectNoBindRoleUser(sysRole);
        //生成PageInfo对象
        PageInfo<UserInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public String getRoleValue(Integer roleId) {
        return sysRoleMapper.getRoleValue(roleId);
    }

    /*   @Override
       public List<UserInfo> selectRoleUser1(SysRole sysRole) {
           return sysRoleMapper.selectRoleUser1(sysRole);
       }*/


}
