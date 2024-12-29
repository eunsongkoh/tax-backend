package com.song.taxSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.taxSystem.model.CheckoutRequest;
import com.song.taxSystem.model.PItem;
import com.song.taxSystem.model.Purchase;
import com.song.taxSystem.model.User;
import com.song.taxSystem.repository.PItemRepository;
import com.song.taxSystem.repository.PurchaseRepository;
import com.song.taxSystem.repository.UserRepository;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private PurchaseRepository purchaseRepository;
    
    @Autowired
    private PItemRepository pItemRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> checkout(@RequestBody CheckoutRequest checkoutRequest) {
        User user = userRepository.findById(checkoutRequest.getUserId()).orElse(null);
        Map<String, Object> response = new HashMap<>();
        if (user == null) {
            response.put("message", "User Not Found");
            return ResponseEntity.status(404).body(response);
        }

        Purchase newPurchase = new Purchase();
        newPurchase.setUserId(user.getId());
        newPurchase.setTotal(checkoutRequest.getTotal());
        newPurchase = purchaseRepository.save(newPurchase); 

        List<PItem> items = checkoutRequest.getItems();
        if (items == null || items.isEmpty()) {
            response.put("message", "No Items Provided");
            return ResponseEntity.status(400).body(response);
        }

        for (PItem item : items) {
            item.setPurchaseId(newPurchase.getPurchaseId()); 
        }

        pItemRepository.saveAll(items);

        response.put("message", "\"Checkout successful.");
        response.put("pid", newPurchase.getPurchaseId());

        return ResponseEntity.ok(response);
    }

    // @PutMapping("/{userId}")
    // public ResponseEntity<String> checkout(@PathVariable int userId, @RequestBody List<PItem> items) {
    //     User user = userRepository.findById(userId).orElse(null);
    //     if (user == null) {
    //         return ResponseEntity.status(404).body("User not found");
    //     }

      
    //     Purchase newPurchase = new Purchase();
    //     newPurchase.setUserId(user.getId());
    //     newPurchase = purchaseRepository.save(newPurchase); 


    //     for (PItem item : items) {
    //         item.setPurchaseId(newPurchase.getPurchaseId()); 
    //         pItemRepository.save(item); 
    //     }

    //     return ResponseEntity.ok("Checkout successful. Purchase created with pid: " + newPurchase.getPurchaseId());
    // }
}
