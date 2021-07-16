package com.example.vd.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "phone")
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
