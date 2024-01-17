package com.webtoon.webtoonservice.repository;

import com.webtoon.webtoonservice.model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    List<SearchHistory> findByContentId(Long contentId);
    // Additional methods if needed, for example, to find searches by content

    void deleteByUserId(Long userId);
}