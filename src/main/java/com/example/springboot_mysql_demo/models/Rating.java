package com.example.springboot_mysql_demo.models;

import jakarta.persistence.*;

@Entity(name = "Ratings")
public class Rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;

    // Rating -> user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Movie -> Rating
    @ManyToOne
    @JoinColumn(name = "move_id")
    private Movie movie;

    public int getScore() {
        return score;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }
}
