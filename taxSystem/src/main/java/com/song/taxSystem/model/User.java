package com.song.taxSystem.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("Users")
public class User {
    @Id
    @Column("UserID")
    private int userId;

    @Column("UserName")
    private String userName;

    @Column("Email")
    private String email;

    @Column("PasswordHash")
    private String passwordHash;

    public User() {
    }

    public User(int _userID, String _username, String _email, String _hashedPassword) {
        this.userId = _userID;
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

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String newPassword) {
        this.passwordHash = newPassword;
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
 