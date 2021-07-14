package com.example.vd.dao;

import com.example.vd.entity.Consult;
import com.example.vd.entity.ConsultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.sql.Timestamp;
import java.util.List;

@Transactional
public interface ConsultRepository extends JpaRepository<ConsultEntity, Integer> {
    @Query(value = "select * from consult where user_id = ?",nativeQuery = true)
    List<ConsultEntity> findByUserId(int id);

    @Query(value = "select * from consult where doc_id = ?",nativeQuery = true)
    List<ConsultEntity> findByDoctorId(int id);

    @Modifying
    @Query(value = "insert into consult(name,gender,age,id_number,phone,user_id,doc_id,diag,drug_ids,des,pics,create_time) values (?,?,?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
    void addConsult(String name, int gender, int age, String id_number, String phone, int user_id, int doc_id, String diag, String drug_ids, String des, String pics, Timestamp time);

    @Modifying
    @Query(value = "update consult set status='1' where id= ?", nativeQuery = true)
    void modifyStatus(int id);
}
