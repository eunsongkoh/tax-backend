package com.song.taxSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.taxSystem.model.PItem;
import com.song.taxSystem.model.Purchase;
import com.song.taxSystem.model.User;
import com.song.taxSystem.model.UserRequest;
import com.song.taxSystem.repository.PItemRepository;
import com.song.taxSystem.repository.PurchaseRepository;
import com.song.taxSystem.repository.UserRepository;

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
        // System.out.println("Received User: " + newUser);
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

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody UserRequest loginRequest) {
        String userName = loginRequest.getUserName();
        String passwordHash = loginRequest.getPasswordHash();
        // System.out.println("Received Request: " + userName + " " + passwordHash);

        User user = userRepository.findByUserNameAndPasswordHash(userName, passwordHash);
        Map<String, Object> response = new HashMap<>();

        if (user != null) {
            response.put("message", "User exists");
            response.put("userId", user.getId()); 
            List<Purchase> totalPurchases = purchaseRepository.findByUserId(user.getId());
            // System.out.println("Purchases: " + totalPurchases);
            response.put("purchases", totalPurchases);
            
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(401).body(response);
        }
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

    // @GetMapping("/user/{userId}/purchases")
    // public ResponseEntity<List<Purchase>> getUserPurchases(@PathVariable int userId) {
    //     List<Purchase> purchases = purchaseRepository.findByUserId(userId);

    //     for (Purchase purchase : purchases) {
    //         List<PItem> items = pItemRepository.findByPurchaseId(purchase.getPurchaseId());
    //         purchase.setItems(items); 
    //     }

    //     return ResponseEntity.ok(purchases);
    // }
}
