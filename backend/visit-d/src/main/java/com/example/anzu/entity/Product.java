package com.example.anzu.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "shop_id")
    private String uid;
    @Column(name = "name")
    private String goodsMain;
    @Column(name = "second_name")
    private String goodsSub;
    @Column(name = "type")
    private String goodsType;
    @Column(name = "detail")
    private String goodsDetail;
    @Column(name = "rule")
    private String goodsRule;
    @Column(name = "price_content")
    private String goodsPriceContent;
    @Column(name = "price_date")
    private String goodsPriceDate;
    @Column(name = "stock")
    private String goodsInventory;
    @Column(name = "mode")
    private String goodsMode;
    @Column(name = "cover")
    private String goodsCover;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGoodsMain() {
        return goodsMain;
    }

    public void setGoodsMain(String goodsMain) {
        this.goodsMain = goodsMain;
    }

    public String getGoodsSub() {
        return goodsSub;
    }

    public void setGoodsSub(String goodsSub) {
        this.goodsSub = goodsSub;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getGoodsRule() {
        return goodsRule;
    }

    public void setGoodsRule(String goodsRule) {
        this.goodsRule = goodsRule;
    }

    public String getGoodsPriceContent() {
        return goodsPriceContent;
    }

    public void setGoodsPriceContent(String goodsPriceContent) {
        this.goodsPriceContent = goodsPriceContent;
    }

    public String getGoodsPriceDate() {
        return goodsPriceDate;
    }

    public void setGoodsPriceDate(String goodsPriceDate) {
        this.goodsPriceDate = goodsPriceDate;
    }

    public String getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(String goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getGoodsMode() {
        return goodsMode;
    }

    public void setGoodsMode(String goodsMode) {
        this.goodsMode = goodsMode;
    }

    public String getGoodsCover() {
        return goodsCover;
    }

    public void setGoodsCover(String goodsCover) {
        this.goodsCover = goodsCover;
    }
}
