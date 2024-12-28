package com.song.taxSystem.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@Table("Users")
public class User {
    @Id
    @Column("UserID")
    private int userId;
    
    @JsonProperty("userName")
    @Column("UserName")
    private String userName;

    @Column("Email")
    private String email;

    @Column("PasswordHash")
    private String passwordHash;
    
    
    private List<Purchase> purchases;

    public User() {
    }

    public User(String _username, String _email, String _hashedPassword) {
        this.userName = _username;
        this.email = _email;
        this.passwordHash = _hashedPassword;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String newUsername) {
        this.userName = newUsername;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return userId;
    }

    public void setId(int userId){
        this.userId = userId; 
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, passwordHash, email);
    }
}
 