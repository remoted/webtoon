package com.webtoon.webtoonservice.model;

import jakarta.persistence.*;

import java.util.Date;
import lombok.*;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    private int episodeNumber;
    private String episodeTitle;
    private Date releaseDate;
}
