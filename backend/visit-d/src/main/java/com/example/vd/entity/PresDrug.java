package com.example.vd.entity;

import javax.persistence.*;

@Entity
@Table(name = "pres_drug")
public class PresDrug {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "pres_id")
    private int presId;
    @Column(name = "drug_name")
    private String drugName;
    @Column(name = "dose")
    private String dose;
    @Column(name = "dose_unit")
    private String doseUnit;
    @Column(name = "frequency")
    private String frequency;
    @Column(name = "usage")
    private String usage;
    @Column(name = "take_days")
    private int takeDays;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "remark")
    private String remark;


}
