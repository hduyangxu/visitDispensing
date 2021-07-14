package com.example.vd.dao;

import com.example.vd.entity.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository extends JpaRepository<DrugEntity, Integer> {
    List<DrugEntity> findAll();
}
