package com.webtoon.webtoonservice.repository;
import com.webtoon.webtoonservice.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    boolean existsByUserIdAndContentId(Long userId, Long contentId);

    @Query("SELECT e.content, COUNT(e) as cnt FROM Evaluation e WHERE e.likes = true GROUP BY e.content ORDER BY cnt DESC")
    List<Object[]> findTopContentsByLikes();

    @Query("SELECT e.content, COUNT(e) as cnt FROM Evaluation e WHERE e.unlike = true GROUP BY e.content ORDER BY cnt DESC")
    List<Object[]> findTopContentsByUnlikes();

    void deleteByUserId(Long userId);
}