package com.webtoon.webtoonservice.service;

import com.webtoon.webtoonservice.model.Content;
import com.webtoon.webtoonservice.model.SearchHistory;
import com.webtoon.webtoonservice.model.User;
import com.webtoon.webtoonservice.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SearchHistoryService {
    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    public List<SearchHistory> getSearchHistoryForContent(Long contentId) {
        // Logic to retrieve search history for a specific content
        // Assuming a method in the repository to find by contentId
        return searchHistoryRepository.findByContentId(contentId);
    }

    public void logSearchAction(User user, Content content) {
        // Logic to log a new search action
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setUser(user);
        searchHistory.setContent(content);
        searchHistory.setSearchDate(new Date());
        searchHistoryRepository.save(searchHistory);
    }

    // Additional methods as needed
}
