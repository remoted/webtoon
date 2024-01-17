package com.webtoon.webtoonservice.controller;
import com.webtoon.webtoonservice.model.User;
import com.webtoon.webtoonservice.service.ViewHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-views")
public class ViewHistoryController {

    @Autowired
    private ViewHistoryService viewHistoryService;

    @GetMapping("/adult-contents")
    public ResponseEntity<List<User>> getUsersWhoViewedAdultContent() {
        List<User> users = viewHistoryService.getUsersWhoViewedAdultContent();
        return ResponseEntity.ok(users);
    }
}
