package com.webtoon.webtoonservice.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contentsName;
    private String author;
    private int coin;
    private Date openDate;

    @Column(nullable = false)
    private Boolean adult = false; // Default value

    @OneToMany(mappedBy = "content")
    private List<Episode> episodes;
}
