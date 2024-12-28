package com.song.taxSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.song.taxSystem.model.PItem;

public interface PItemRepository extends CrudRepository<PItem, Integer>{
    List<PItem> findByPurchaseId(int purchaseId); 
}
