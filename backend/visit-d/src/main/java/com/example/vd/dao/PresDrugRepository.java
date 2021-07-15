package com.example.vd.dao;

import com.example.vd.entity.PresDrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PresDrugRepository extends JpaRepository<PresDrugEntity, Integer> {
    @Query(value = "select * from pres_drug where id = ?",nativeQuery = true)
    List<PresDrugEntity> findOne(int id);

    @Query(value = "select * from pres_drug where pres_id = ?",nativeQuery = true)
    List<PresDrugEntity> findByPresId(int id);

    @Modifying
    @Query(value = "insert into pres_drug(pres_id,drug_name,dose,dose_unit,frequency,drug_usage,take_days,quantity,price,remark) values (?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
    void addPresDrug(int pres_id, String drug_name, String dose, String dose_unit, String frequency, String drug_usage, int take_days, int quantity, double price, String remark);

    @Modifying
    @Query(value = "delete from pres_drug where id=?",nativeQuery = true)
    void deleteById(int id);

}
