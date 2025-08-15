package com.example.springboot_mysql_demo.repositories;

import com.example.springboot_mysql_demo.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
