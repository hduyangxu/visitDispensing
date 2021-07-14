package com.example.vd.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "drug")
public class Drug {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "drug_name")
    private String drugName;
    @Column(name = "trade_name")
    private String tradeName;
    @Column(name = "pinyin_code")
    private String pinyinCode;
    @Column(name = "specification")
    private String specification;
    @Column(name = "pack_unit")
    private char packUnit;
    @Column(name = "price", length = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "dose", length = 10, scale = 2)
    private BigDecimal dose;
    @Column(name = "dose_unit")
    private String doseUnit;
    @Column(name = "factory_name")
    private String factoryName;
    @Column(name = "approval_number")
    private String approval_number;

}
