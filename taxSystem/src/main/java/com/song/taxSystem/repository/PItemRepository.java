package com.song.taxSystem.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.song.taxSystem.model.PItem;

@Repository
public interface PItemRepository extends CrudRepository<PItem, Integer>{
    List<PItem> findByPurchaseId(int purchaseId); 
}
