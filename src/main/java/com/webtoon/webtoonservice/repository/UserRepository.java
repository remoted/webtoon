package com.webtoon.webtoonservice.repository;

import com.webtoon.webtoonservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom methods, if needed
}