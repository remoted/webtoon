package com.webtoon.webtoonservice.controller;

import com.webtoon.webtoonservice.model.Evaluation;
import com.webtoon.webtoonservice.model.dto.EvaluationDto;
import com.webtoon.webtoonservice.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping
    public ResponseEntity<List<Evaluation>> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
        return ResponseEntity.ok(evaluations);
    }


    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody EvaluationDto evaluationDto,
                                                       @RequestParam Long userId,
                                                       @RequestParam Long contentId) {
        Evaluation evaluation = new Evaluation();
        // Map fields from evaluationDto to evaluation
        evaluation.setLikes(evaluationDto.getLike());
        evaluation.setUnlike(evaluationDto.getUnlike());
        evaluation.setComment(evaluationDto.getComment());

        Evaluation createdEvaluation = evaluationService.evaluateContent(userId, contentId, evaluation);
        return ResponseEntity.ok(createdEvaluation);
    }

    @GetMapping("/top-contents")
    public ResponseEntity<?> getTopContentsByLikesAndUnlikes() {
        return ResponseEntity.ok(evaluationService.getTopContentsByLikesAndUnlikes());
    }
}
