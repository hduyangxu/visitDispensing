package com.example.vd.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "drug", schema = "visit", catalog = "")
public class DrugEntity {
    private int id;
    private String drugName;
    private String tradeName;
    private String pinyinCode;
    private String specification;
    private String packUnit;
    private double price;
    private double dose;
    private String doseUnit;
    private String factoryName;
    private String approvalNumber;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "drug_name")
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Basic
    @Column(name = "trade_name")
    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    @Basic
    @Column(name = "pinyin_code")
    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    @Basic
    @Column(name = "specification")
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "pack_unit")
    public String getPackUnit() {
        return packUnit;
    }

    public void setPackUnit(String packUnit) {
        this.packUnit = packUnit;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "dose")
    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    @Basic
    @Column(name = "dose_unit")
    public String getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit;
    }

    @Basic
    @Column(name = "factory_name")
    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Basic
    @Column(name = "approval_number")
    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrugEntity that = (DrugEntity) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                Double.compare(that.dose, dose) == 0 &&
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(tradeName, that.tradeName) &&
                Objects.equals(pinyinCode, that.pinyinCode) &&
                Objects.equals(specification, that.specification) &&
                Objects.equals(packUnit, that.packUnit) &&
                Objects.equals(doseUnit, that.doseUnit) &&
                Objects.equals(factoryName, that.factoryName) &&
                Objects.equals(approvalNumber, that.approvalNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drugName, tradeName, pinyinCode, specification, packUnit, price, dose, doseUnit, factoryName, approvalNumber);
    }
}
