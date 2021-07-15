package com.example.vd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "consult", schema = "visit", catalog = "")
public class ConsultEntity {
    private int id;
    private String name;
    private int gender;
    private int age;
    private String idNumber;
    private Timestamp birth;
    private String phone;
    private int userId;
    private int docId;
    private String diag;
    private String drugIds;
    private String des;
    private String pics;
    private String status;
    private Timestamp createTime;
    private Timestamp finishTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender")
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "id_number")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "birth")
    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "doc_id")
    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    @Basic
    @Column(name = "diag")
    public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    @Basic
    @Column(name = "drug_ids")
    public String getDrugIds() {
        return drugIds;
    }

    public void setDrugIds(String drugIds) {
        this.drugIds = drugIds;
    }

    @Basic
    @Column(name = "des")
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Basic
    @Column(name = "pics")
    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "finish_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultEntity that = (ConsultEntity) o;
        return id == that.id &&
                gender == that.gender &&
                age == that.age &&
                userId == that.userId &&
                docId == that.docId &&
                Objects.equals(name, that.name) &&
                Objects.equals(idNumber, that.idNumber) &&
                Objects.equals(birth, that.birth) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(diag, that.diag) &&
                Objects.equals(drugIds, that.drugIds) &&
                Objects.equals(des, that.des) &&
                Objects.equals(pics, that.pics) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(finishTime, that.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age, idNumber, birth, phone, userId, docId, diag, drugIds, des, pics, status, createTime, finishTime);
    }
}
