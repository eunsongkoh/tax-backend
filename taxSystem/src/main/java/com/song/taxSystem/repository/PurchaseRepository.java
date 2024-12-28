package com.song.taxSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.song.taxSystem.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{
    List<Purchase> findByUserId(int userId); 
}
