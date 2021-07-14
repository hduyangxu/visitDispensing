package com.example.vd.dao;

import com.example.vd.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserReposity extends JpaRepository<UserEntity, Integer> {
    @Query(value = "select * from user where open_id = ?",nativeQuery = true)
    List<UserEntity> findByOpenId(String open_id);

    @Modifying
    @Query(value = "insert into user(open_id,phone) values (?,?)", nativeQuery = true)
    void addUser(String open_id, String phone);
}
