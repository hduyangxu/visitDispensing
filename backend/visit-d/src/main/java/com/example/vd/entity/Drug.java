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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public char getPackUnit() {
        return packUnit;
    }

    public void setPackUnit(char packUnit) {
        this.packUnit = packUnit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDose() {
        return dose;
    }

    public void setDose(BigDecimal dose) {
        this.dose = dose;
    }

    public String getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getApproval_number() {
        return approval_number;
    }

    public void setApproval_number(String approval_number) {
        this.approval_number = approval_number;
    }
}
