package com.webtoon.webtoonservice.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluationDto {
    private Long id;
    private UserDto user;
    private Boolean likes;
    private Boolean unlike;
    private String comment;

    // Constructors, Getters, and Setters

    public EvaluationDto() {}

    public EvaluationDto(Boolean likes, Boolean unlike, String comment) {
        this.likes = likes;
        this.unlike = unlike;
        this.comment = comment;
    }

    // Standard getters and setters

    public Boolean getLike() {
        return likes;
    }

    public void setLike(Boolean like) {
        this.likes = like;
    }

    public Boolean getUnlike() {
        return unlike;
    }

    public void setUnlike(Boolean unlike) {
        this.unlike = unlike;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
