package com.example.anzu.dao;

import com.example.anzu.entity.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopUserRepository extends JpaRepository<ShopUser, String> {
    List<ShopUser> findAll();
    //判断账号密码是否正确
    ShopUser findByCellphoneAndPassword(String cellphone, String password);
    //判断手机号是否已注册
    ShopUser findByCellphone(String cellphone);
}
