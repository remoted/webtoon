package com.webtoon.webtoonservice.service;
import com.webtoon.webtoonservice.model.User;
import com.webtoon.webtoonservice.model.ViewHistory;
import com.webtoon.webtoonservice.repository.ViewHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViewHistoryService {
    @Autowired
    private ViewHistoryRepository viewHistoryRepository;

    public List<User> getUsersWhoViewedAdultContent() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date weekAgo = calendar.getTime();

        List<ViewHistory> views = viewHistoryRepository.findAdultContentViews(weekAgo);

        return views.stream()
                .collect(Collectors.groupingBy(ViewHistory::getUser))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
