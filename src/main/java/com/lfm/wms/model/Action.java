package com.lfm.wms.model;

/**
 * @author lfm
 * @date 2019/12/11 - 10:03
 */
public class Action {
    private Integer id;
    private String actionName;
    private String url;
    private String founder;
    private String modifie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getModifie() {
        return modifie;
    }

    public void setModifie(String modifie) {
        this.modifie = modifie;
    }
}
