package com.song.taxSystem.controller;

import com.song.taxSystem.model.User;
import com.song.taxSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User newUser){
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.ok("User {"+savedUser.getId()+"} was created successfully");
    }

    @GetMapping
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/profile")
    public User getUserById(@RequestBody int id){
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUserById(@RequestBody int id){
        userRepository.deleteById(id);
        return ResponseEntity.ok("User {"+id+"} was deleted successfully");
    }

    @PutMapping()
    public User editUser(@RequestBody int id, @RequestBody User user){
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser == null){
            throw new RuntimeException("User {"+id+"} not found");
        }
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
}
