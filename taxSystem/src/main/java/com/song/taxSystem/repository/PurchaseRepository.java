package com.song.taxSystem.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.song.taxSystem.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{
    // @Query("SELECT * FROM Purchases WHERE UserId = :userId")
    // List<Purchase> findByUserId(int userId);
}
