package com.song.taxSystem.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("users")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;

    public User() {
    }

    public User(int _id, String _username, String _password, String _email) {
        this.id = _id;
        this.username = _username;
        this.password = _password;
        this.email = _email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email);
    }
}
 