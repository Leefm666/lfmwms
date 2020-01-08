package com.lfm.wms.model;

/**
 * @author lfm
 * @date 2019/12/21 - 16:34
 */
public class GoodsUnit {
    private Integer id; // 编号
    private String name; // 商品单位名称

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

    @Override
    public String toString() {
        return "GoodsUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
