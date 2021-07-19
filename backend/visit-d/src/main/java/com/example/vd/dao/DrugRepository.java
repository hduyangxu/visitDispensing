package com.example.vd.dao;

import com.example.vd.entity.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugRepository extends JpaRepository<DrugEntity, Integer> {

    List<DrugEntity> findAll();

    @Query(value = "select * from drug where id = ?",nativeQuery = true)
    List<DrugEntity> findById(int id);

    @Query(value = "select * from drug where pinyin_code like ?1% limit 20", nativeQuery = true)
    List<DrugEntity> findByCodeLike(String code);

    @Query(value = "select * from drug where trade_name like %?1% limit 20", nativeQuery = true)
    List<DrugEntity> findByNameLike(String name);

    @Modifying
    @Query(value = "insert into drug(drug_name,trade_name,pinyin_code,specification,pack_unit,price,dose,dose_unit,factory_name,approval_number) values (?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
    int addDrug(String drug_name, String trade_name, String pinyin_code, String specification, char pack_unit, double price, double dose, String dose_unit, String factory_name, String approval_number);

    @Modifying
    @Query(value = "update drug set drug_name=?,trade_name=?,pinyin_code=?,specification=?,pack_unit=?,price=?,dose=?,dose_unit=?,factory_name=?,approval_number=? where id=?", nativeQuery = true)
    int modifyDrug(String drug_name, String trade_name, String pinyin_code, String specification, char pack_unit, double price, double dose, String dose_unit, String factory_name, String approval_number, int id);

    @Modifying
    @Query(value = "delete from drug where id=?",nativeQuery = true)
    int deleteById(int id);

}
