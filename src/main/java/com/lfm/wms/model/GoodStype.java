package com.lfm.wms.model;

/**
 * @author lfm
 * @date 2019/12/19 - 10:11
 */
public class GoodStype {
    private Integer id;
    private String name;
    private Integer pId;
    private Integer  state;
    private String icon;

    @Override
    public String toString() {
        return "GoodStype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pId=" + pId +
                ", state=" + state +
                ", icon='" + icon + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
