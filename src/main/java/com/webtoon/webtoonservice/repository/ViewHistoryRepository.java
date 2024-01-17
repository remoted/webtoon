package com.webtoon.webtoonservice.repository;

import com.webtoon.webtoonservice.model.ViewHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

public interface ViewHistoryRepository extends JpaRepository<ViewHistory, Long> {
    @Query("SELECT v FROM ViewHistory v WHERE v.content.adult = true AND v.viewDate > :weekAgo")
    List<ViewHistory> findAdultContentViews(Date weekAgo);
}