package com.example.vd.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pres_info", schema = "visit", catalog = "")
public class PresInfoEntity {
    private int id;
    private int userId;
    private int consultId;
    private String type;
    private Integer doctorId;
    private String doctorName;
    private Timestamp createTime;
    private String presStatus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "consult_id")
    public int getConsultId() {
        return consultId;
    }

    public void setConsultId(int consultId) {
        this.consultId = consultId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "doctor_id")
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "doctor_name")
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "pres_status")
    public String getPresStatus() {
        return presStatus;
    }

    public void setPresStatus(String presStatus) {
        this.presStatus = presStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresInfoEntity that = (PresInfoEntity) o;
        return id == that.id &&
                userId == that.userId &&
                consultId == that.consultId &&
                Objects.equals(type, that.type) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(presStatus, that.presStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, consultId, type, doctorId, doctorName, createTime, presStatus);
    }
}
