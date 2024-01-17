package com.webtoon.webtoonservice.service;

import com.webtoon.webtoonservice.model.Content;
import com.webtoon.webtoonservice.model.Evaluation;
import com.webtoon.webtoonservice.model.User;
import com.webtoon.webtoonservice.repository.ContentRepository;
import com.webtoon.webtoonservice.repository.EvaluationRepository;
import com.webtoon.webtoonservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContentRepository contentRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public List<Content> getTopContentsByLikesAndUnlikes() {
        // Fetch top contents based on likes
        List<Content> topLikedContents = evaluationRepository.findTopContentsByLikes()
                .stream()
                .map(result -> (Content) result[0])  // Assuming the Content is the first element
                .limit(3) // Limit to top 3
                .collect(Collectors.toList());

        // Fetch top contents based on unlikes
        List<Content> topUnlikedContents = evaluationRepository.findTopContentsByUnlikes()
                .stream()
                .map(result -> (Content) result[0])  // Assuming the Content is the first element
                .limit(3) // Limit to top 3
                .collect(Collectors.toList());

        // Combine both lists, removing duplicates
        List<Content> combinedList = Stream.concat(topLikedContents.stream(), topUnlikedContents.stream())
                .distinct()
                .collect(Collectors.toList());

        return combinedList;
    }

    @Transactional
    public Evaluation evaluateContent(Long userId, Long contentId, Evaluation evaluation) {

        Assert.notNull(evaluation.getLikes() || evaluation.getUnlike(), "Either 'like' or 'unlike' must be set");

        if (evaluationRepository.existsByUserIdAndContentId(userId, contentId)) {
            throw new IllegalStateException("User has already evaluated this content");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new IllegalArgumentException("Content not found"));

        evaluation.setUser(user);
        evaluation.setContent(content);

        return evaluationRepository.save(evaluation);
    }
}
