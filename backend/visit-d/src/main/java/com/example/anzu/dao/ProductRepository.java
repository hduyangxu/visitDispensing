package com.example.anzu.dao;

import com.example.anzu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    //获取所有商品信息
    List<Product> findAll();
    //根据uid获取商品信息
    List<Product> findByUid(String uid);
}
