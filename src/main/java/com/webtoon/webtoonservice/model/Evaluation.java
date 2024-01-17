package com.webtoon.webtoonservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@Getter
@Setter
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Assuming there's a User entity

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;  // Assuming there's a Content entity

    private Boolean likes;
    private Boolean unlike;
    private String comment; // Ensure validation to disallow special characters

    public void setComment(String comment) {
        if (comment != null && !Pattern.matches("[\\w\\s]+", comment)) {
            throw new IllegalArgumentException("Comments can't contain special characters");
        }
        this.comment = comment;
    }

    public void setLikes(Boolean like) {
        this.likes = like;
        if (like != null && like && this.unlike != null && this.unlike) {
            throw new IllegalStateException("Cannot set both like and unlike");
        }
    }

    public void setUnlike(Boolean unlike) {
        this.unlike = unlike;
        if (unlike != null && unlike && this.likes != null && this.likes) {
            throw new IllegalStateException("Cannot set both like and unlike");
        }
    }

}
