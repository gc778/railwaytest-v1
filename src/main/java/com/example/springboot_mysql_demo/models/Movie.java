package com.example.springboot_mysql_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<Rating> ratings;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
}
