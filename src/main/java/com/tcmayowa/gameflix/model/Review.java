/*package com.tcmayowa.gameflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;  // Who wrote the review
    private String comment;   // Review content

    // Default constructor
    public Review() {}

    // Optional constructor
    public Review(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {  // Needed by PageController
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {    // Needed by PageController
        this.comment = comment;
    }
}*/

/*package com.tcmayowa.gameflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;  // Who wrote the review
    private String comment;   // Review content

    @ManyToOne
    @JoinColumn(name = "game_id") // foreign key in reviews table
    private Game game;

    // Constructors
    public Review() {}

    public Review(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }
}*/

package com.tcmayowa.gameflix.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;  // Who wrote the review
    private String comment;   // Review content

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference
    private Game game;

    // Default constructor
    public Review() {}

    // Optional constructor
    public Review(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }
}


