package com.webtoon.webtoonservice.controller;

import com.webtoon.webtoonservice.model.Content;
import com.webtoon.webtoonservice.model.dto.FeeUpdateRequest;
import com.webtoon.webtoonservice.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    // Get all contents
    @GetMapping
    public ResponseEntity<List<Content>> getAllContents() {
        List<Content> contents = contentService.findAll();
        return ResponseEntity.ok(contents);
    }

    // Get a single content by ID
    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id) {
        Content content = contentService.findById(id);
        return ResponseEntity.ok(content);
    }

    // Create a new content
    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content) {
        Content createdContent = contentService.save(content);
        return ResponseEntity.ok(createdContent);
    }

    // Update an existing content
    @PutMapping("/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @RequestBody Content contentDetails) {
        Content updatedContent = contentService.update(id, contentDetails);
        return ResponseEntity.ok(updatedContent);
    }

    // Delete a content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.delete(id);
        return ResponseEntity.ok().build();
    }

    // 요금 변경
    @PutMapping("/{contentId}/fee")
    public ResponseEntity<Content> updateContentFee(@PathVariable Long contentId, @RequestBody FeeUpdateRequest feeUpdateRequest) {
        Content updatedContent = contentService.updateContentFee(contentId, feeUpdateRequest.getFee());
        return ResponseEntity.ok(updatedContent);
    }
}
