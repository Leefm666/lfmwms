package com.lfm.wms.model;




public class RolePerm {

    private Integer id;

    /**
     * 权限id
     */

    private String permId;

    /**
     * 角色id
     */

    private String roleId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}