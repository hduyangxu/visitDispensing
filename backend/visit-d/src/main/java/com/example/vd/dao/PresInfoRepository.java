package com.example.vd.dao;

import com.example.vd.entity.PresInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface PresInfoRepository extends JpaRepository<PresInfoEntity, Integer> {

    @Query(value = "select * from pres_info where id = ?",nativeQuery = true)
    List<PresInfoEntity> findOne(int id);

    @Query(value = "select * from pres_info where consult_id = ?",nativeQuery = true)
    List<PresInfoEntity> findByConsultId(int id);

    @Modifying
    @Query(value = "insert into pres_info(user_id,consult_id,type,doctor_id,doctor_name,create_time) values (?,?,?,?,?,?)", nativeQuery = true)
    int addPresInfo(int user_id, int consult_id, char type, int doctor_id, String doctor_name, Timestamp time);

    @Modifying
    @Query(value = "delete from pres_info where id=?",nativeQuery = true)
    int deleteById(int id);

    @Modifying
    @Query(value = "update pres_info set pres_status='1' where id= ?", nativeQuery = true)
    int modifyStatus(int id);

}
