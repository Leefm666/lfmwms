package com.lfm.wms.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class SysRole {
    /**
     * 角色名称
     */

    private Integer id;

    /**
     * 角色名称，用于显示
     */

    private String roleName;

    /**
     * 角色描述
     */

    private String roleDesc;

    /**
     * 角色值，用于权限判断
     */

    private String roleValue;

    @DateTimeFormat(pattern = "YYYY-MM-DD'T'HH:mm:ss.sssZ")
    private Date createTime;

    @DateTimeFormat(pattern = "YYYY-MM-DD'T'HH:mm:ss.sssZ")
    private Date updateTime;

    /**
     * 是否禁用
     */

    private Integer isDisable;

    /**
     * 获取角色名称
     *
     * @return id - 角色名称
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleValue='" + roleValue + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDisable=" + isDisable +
                '}';
    }
}