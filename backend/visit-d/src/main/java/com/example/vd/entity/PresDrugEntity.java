package com.example.vd.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pres_drug", schema = "visit", catalog = "")
public class PresDrugEntity {
    private int id;
    private int presId;
    private String drugName;
    private String dose;
    private String doseUnit;
    private String frequency;
    private String drugUsage;
    private int takeDays;
    private int quantity;
    private double price;
    private String remark;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pres_id")
    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
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
    @Column(name = "dose")
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
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
    @Column(name = "frequency")
    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Basic
    @Column(name = "drug_usage")
    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    @Basic
    @Column(name = "take_days")
    public int getTakeDays() {
        return takeDays;
    }

    public void setTakeDays(int takeDays) {
        this.takeDays = takeDays;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresDrugEntity that = (PresDrugEntity) o;
        return id == that.id &&
                presId == that.presId &&
                takeDays == that.takeDays &&
                quantity == that.quantity &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(dose, that.dose) &&
                Objects.equals(doseUnit, that.doseUnit) &&
                Objects.equals(frequency, that.frequency) &&
                Objects.equals(drugUsage, that.drugUsage) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, presId, drugName, dose, doseUnit, frequency, drugUsage, takeDays, quantity, price, remark);
    }
}
