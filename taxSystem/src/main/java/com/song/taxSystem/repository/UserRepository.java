package com.song.taxSystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.song.taxSystem.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT * FROM Users WHERE UserName = :userName AND PasswordHash = :passwordHash")
    User findByUserNameAndPasswordHash(@Param("userName") String userName, @Param("passwordHash") String passwordHash);
}