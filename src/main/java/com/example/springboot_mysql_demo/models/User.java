package com.example.springboot_mysql_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // User -> Rating
    // One user to many ratings

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Rating> ratings;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
