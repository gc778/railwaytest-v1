package com.example.springboot_mysql_demo.repositories;

import com.example.springboot_mysql_demo.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
