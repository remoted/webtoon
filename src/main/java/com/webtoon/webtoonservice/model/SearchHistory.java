package com.webtoon.webtoonservice.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Assuming there's a User entity

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;  // Assuming there's a Content entity

    @Temporal(TemporalType.TIMESTAMP)
    private Date searchDate;

}
