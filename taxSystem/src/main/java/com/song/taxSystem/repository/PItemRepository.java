package com.song.taxSystem.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.song.taxSystem.model.PItem;

public interface PItemRepository extends CrudRepository<PItem, Integer>{
    List<PItem> findByPurchaseId(int purchaseId); 
}
