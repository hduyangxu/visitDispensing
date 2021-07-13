package com.example.anzu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "shop_user")
public class ShopUser {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "uid")
    private String uid;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "password")
    private String password;
//    @Column(name = "register_time")
//    private Timestamp registerTime;
//    @Column(name = "last_login_time")
//    private Timestamp lastLoginTime;

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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Timestamp getRegisterTime() {
//        return registerTime;
//    }
//
//    public void setRegisterTime(Timestamp registerTime) {
//        this.registerTime = registerTime;
//    }
//
//    public Timestamp getLastLoginTime() {
//        return lastLoginTime;
//    }
//
//    public void setLastLoginTime(Timestamp lastLoginTime) {
//        this.lastLoginTime = lastLoginTime;
//    }
}
