package com.song.taxSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.song.taxSystem.model.PItem;
import com.song.taxSystem.model.Purchase;
import com.song.taxSystem.model.User;
import com.song.taxSystem.repository.PItemRepository;
import com.song.taxSystem.repository.PurchaseRepository;
import com.song.taxSystem.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private PurchaseRepository purchaseRepository;
    
    @Autowired
    private PItemRepository pItemRepository;
    
    @Autowired
    private UserRepository userRepository;

    @PutMapping("/{userId}")
    public ResponseEntity<String> checkout(@PathVariable int userId, @RequestBody List<PItem> items) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

      
        Purchase newPurchase = new Purchase();
        newPurchase.setUserId(user.getId());
        newPurchase = purchaseRepository.save(newPurchase); 


        for (PItem item : items) {
            item.setPurchaseId(newPurchase.getPurchaseId()); 
            pItemRepository.save(item); 
        }

        return ResponseEntity.ok("Checkout successful. Purchase created with pid: " + newPurchase.getPurchaseId());
    }
}