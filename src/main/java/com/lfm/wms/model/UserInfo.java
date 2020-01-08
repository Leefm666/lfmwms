package com.lfm.wms.model;


import java.beans.Transient;
import java.util.Set;

/**
 * @author lfm
 * @date 2019/10/25 - 0:21
 */
public class UserInfo {

    /**
     * 主键
     */

    private Integer id;

    /**
     * 用户名
     */

    private String userName;

    private String password;

    /**
     * 加密盐值
     */

    private String salt;

    /**
     * 用户所有角色值，用于shiro做角色权限的判断
     */

    private Set<String> roles;

    /**
     * 用户所有权限值，用于shiro做资源权限的判断
     */

    private Set<String> perms;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPerms() {
        return perms;
    }

    public void setPerms(Set<String> perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roles=" + roles +
                ", perms=" + perms +
                '}';
    }
}

