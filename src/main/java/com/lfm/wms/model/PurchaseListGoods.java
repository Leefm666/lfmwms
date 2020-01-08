package com.lfm.wms.model;

import java.beans.Transient;

/**
 * @author lfm
 * @date 2019/12/24 - 21:22
 */
public class PurchaseListGoods {
    private Integer id; // 编号
    private Integer purchaseListId;
    private PurchaseList purchaseList; // 进货单
    private String code; // 商品编码
    private String name; // 商品名称
    private String model; // 商品型号
    private GoodStype type; // 商品类别
    private Integer typeId; // 类别id
    private Integer goodsId; // 商品id
    private String unit; // 商品单位
    private float price; // 单价
    private int num; // 数量
    private float total; // 总价

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PurchaseList getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(PurchaseList purchaseList) {
        this.purchaseList = purchaseList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public GoodStype getType() {
        return type;
    }

    public Integer getPurchaseListId() {
        return purchaseListId;
    }

    public void setPurchaseListId(Integer purchaseListId) {
        this.purchaseListId = purchaseListId;
    }

    public void setType(GoodStype type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCodeOrName() {
        return codeOrName;
    }

    public void setCodeOrName(String codeOrName) {
        this.codeOrName = codeOrName;
    }

    private String codeOrName; // 查询用到  根据商品编码或者商品名称查询
}
