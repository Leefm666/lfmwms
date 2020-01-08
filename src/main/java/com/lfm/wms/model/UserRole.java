package com.lfm.wms.model;




public class UserRole {

    private Integer id;

    /**
     * 用户ID
     */

    private String userId;

    /**
     * 角色id
     */

    private Integer roleId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}