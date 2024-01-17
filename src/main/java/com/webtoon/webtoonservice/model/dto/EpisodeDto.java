package com.webtoon.webtoonservice.model.dto;

import java.util.Date;

public class EpisodeDto {
    private Long id;
    private String episodeTitle;
    private int episodeNumber;
    private Date releaseDate;

    // Constructors, getters, and setters

    public EpisodeDto() {
        // Default constructor
    }

    // Additional constructor, getters, and setters as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
