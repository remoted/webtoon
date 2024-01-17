package com.webtoon.webtoonservice.service;

import com.webtoon.webtoonservice.model.Content;
import com.webtoon.webtoonservice.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;

    // Get all contents
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    // Get a content by ID
    public Content findById(Long id) {
        Optional<Content> content = contentRepository.findById(id);
        return content.orElse(null);
    }

    // Create or update a content
    public Content save(Content content) {
        return contentRepository.save(content);
    }

    // Delete a content
    public void delete(Long id) {
        contentRepository.deleteById(id);
    }

    public Content update(Long id, Content contentDetails) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id " + id));

        content.setContentsName(contentDetails.getContentsName());
        content.setAuthor(contentDetails.getAuthor());
        content.setCoin(contentDetails.getCoin());
        content.setOpenDate(contentDetails.getOpenDate());
        // Set other fields as needed

        return contentRepository.save(content);
    }


    /**
     * @param contentId
     * @param fee
     * @return
     *
     * 요금 변경 API
     */

    public Content updateContentFee(Long contentId, int fee) {
        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new IllegalArgumentException("Content not found"));

        if (fee < 0 || fee > 500) {
            throw new IllegalArgumentException("Fee must be between 0 and 500");
        }

        content.setCoin(fee);
        return contentRepository.save(content);
    }
}
