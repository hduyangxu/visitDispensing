package com.example.anzu.dao;

import com.example.anzu.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, String> {
    //根据uid得到shop对象
    Shop findByUid(String uid);
}
