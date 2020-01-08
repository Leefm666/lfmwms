package com.lfm.wms.model;

/**
 * @author lfm
 * @date 2019/12/17 - 9:37
 */
public class ActionPerm {
    private Integer id;
    private String actionId;
    private String PerInitId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getPerInitId() {
        return PerInitId;
    }

    public void setPerInitId(String perInitId) {
        PerInitId = perInitId;
    }
}
