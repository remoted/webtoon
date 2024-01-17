package com.webtoon.webtoonservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ContentDto {
    private Long id;
    private String contentsName;
    private String author;
    private int coin;
    private Date openDate;

    // Assuming you have a list of EpisodeDto as part of Content
    private List<EpisodeDto> episodes;

    // Constructors, getters, and setters

    public ContentDto() {
        // Default constructor
    }

    // Additional constructor, getters, and setters as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public List<EpisodeDto> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodeDto> episodes) {
        this.episodes = episodes;
    }
}
