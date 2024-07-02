package com.song.taxSystem.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("users")
public class User {
    @Id
    private int UserID;
    private String UserName;
    private String Email;
    private String PasswordHash;

    public User() {
    }

    public User(int _userID, String _username, String _email, String _hashedPassword) {
        this.UserID = _userID;
        this.UserName = _username;
        this.Email = _email;
        this.PasswordHash = _hashedPassword;
    }

    public String getUsername() {
        return UserName;
    }

    public void setUsername(String newUsername) {
        this.UserName = newUsername;
    }

    public String getPassword() {
        return PasswordHash;
    }

    public void setPassword(String newPassword) {
        this.PasswordHash = newPassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String newEmail) {
        this.Email = newEmail;
    }

    public int getId() {
        return UserID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return UserID == user.UserID && Objects.equals(UserName, user.UserName) && Objects.equals(PasswordHash, user.PasswordHash) && Objects.equals(Email, user.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserID, UserName, PasswordHash, Email);
    }
}
 