package com.webtoon.webtoonservice.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.*;
import java.util.Date;



@Entity
@Table(name = "app_user") // or another non-reserved name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String userEmail;
    private String gender; // Consider using an enum here
    private String type;   // Consider using an enum here
    private Date registerDate;
}
