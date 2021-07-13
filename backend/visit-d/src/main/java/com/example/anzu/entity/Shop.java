package com.example.anzu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "uid")
    private String uid;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "shop_logo")
    private String shopLogo;
    @Column(name = "shop_type")
    private String shopType;
    @Column(name = "shop_address")
    private String shopAddress;
    @Column(name = "holder_name")
    private String holderName;
    @Column(name = "holder_phone")
    private String holderPhone;
//    @Column(name = "holder_id_number")
//    private String holderIdNumber;
//    @Column(name = "holder_email")
//    private String holderEmail;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getHolderPhone() {
        return holderPhone;
    }

    public void setHolderPhone(String holderPhone) {
        this.holderPhone = holderPhone;
    }
    //    public String getHolderIdNumber() {
//        return holderIdNumber;
//    }
//
//    public void setHolderIdNumber(String holderIdNumber) {
//        this.holderIdNumber = holderIdNumber;
//    }
//
//    public String getHolderEmail() {
//        return holderEmail;
//    }
//
//    public void setHolderEmail(String holderEmail) {
//        this.holderEmail = holderEmail;
//    }
}
