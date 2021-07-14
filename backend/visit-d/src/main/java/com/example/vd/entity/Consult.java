package com.example.vd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "consult")
public class Consult {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private int gender;
    @Column(name = "id_number")
    private String idNumber;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @Column(name = "birth")
    private Timestamp birth;
    @Column(name = "phone")
    private String phone;
    @Column(name = "doc_id")
    private int docId;
    @Column(name = "diag")
    private String diag;
    @Column(name = "drug_ids")
    private String drugIds;
    @Column(name = "desc")
    private String desc;
    @Column(name = "pics")
    private String pics;
    @Column(name = "status")
    private char status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @Column(name = "create_time")
    private Timestamp createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @Column(name = "finish_time")
    private Timestamp finishTime;

}
