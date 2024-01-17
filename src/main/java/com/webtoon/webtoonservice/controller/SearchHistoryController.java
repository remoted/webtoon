package com.webtoon.webtoonservice.controller;
import com.webtoon.webtoonservice.model.SearchHistory;
import com.webtoon.webtoonservice.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-history")
public class SearchHistoryController {
    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping("/{contentId}")
    public ResponseEntity<List<SearchHistory>> getSearchHistoryForContent(@PathVariable Long contentId) {
        List<SearchHistory> history = searchHistoryService.getSearchHistoryForContent(contentId);
        return ResponseEntity.ok(history);
    }
}
