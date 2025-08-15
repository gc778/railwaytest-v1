package com.example.springboot_mysql_demo.repositories;

import com.example.springboot_mysql_demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Method that returns a boolean when user email exists in the DB
    boolean existsByEmail(String email);
}
