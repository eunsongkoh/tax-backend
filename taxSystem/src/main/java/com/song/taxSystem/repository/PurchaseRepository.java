package com.song.taxSystem.repository;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.song.taxSystem.model.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{
    @Query("SELECT * FROM Purchases WHERE UserId = :userId")
    List<Purchase> findByUserId(int userId);
}
