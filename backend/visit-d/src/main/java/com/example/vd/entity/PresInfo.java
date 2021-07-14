package com.example.vd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pres_info")
public class PresInfo {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "consult_id")
    private int consultId;
    @Column(name = "type")
    private char type;
    @Column(name = "doctor_id")
    private int doctorId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "pres_status")
    private char presStatus;

}
