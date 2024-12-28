package com.song.taxSystem.controller;

import com.song.taxSystem.model.PItem;
import com.song.taxSystem.model.Purchase;
import com.song.taxSystem.model.User;
import com.song.taxSystem.repository.PItemRepository;
import com.song.taxSystem.repository.PurchaseRepository;
import com.song.taxSystem.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PurchaseRepository purchaseRepository; 

    @Autowired
    private PItemRepository pItemRepository; 

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody User newUser) {
    System.out.println("Received User: " + newUser);
    User savedUser = userRepository.save(newUser);

    Map<String, Object> response = new HashMap<>();
    response.put("message", "User created successfully");
    response.put("userId", savedUser.getId()); 

    return ResponseEntity.ok(response);
}


    @GetMapping("/users")
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/profile")
    public User getUserById(@RequestBody int userId){
        return userRepository.findById(userId).orElse(null);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUserById(@RequestBody int userId){
        userRepository.deleteById(userId);
        return ResponseEntity.ok("User {"+userId+"} was deleted successfully");
    }

    @PutMapping()
    public User editUser(@RequestBody int userId, @RequestBody User user){
        User existingUser = userRepository.findById(userId).orElse(null);
        if(existingUser == null){
            throw new RuntimeException("User {"+userId+"} not found");
        }
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @GetMapping("/user/{userId}/purchases")
    public ResponseEntity<List<Purchase>> getUserPurchases(@PathVariable int userId) {
        List<Purchase> purchases = purchaseRepository.findByUserId(userId);

        for (Purchase purchase : purchases) {
            List<PItem> items = pItemRepository.findByPurchaseId(purchase.getPurchaseId());
            purchase.setItems(items); 
        }

        return ResponseEntity.ok(purchases);
    }
}
