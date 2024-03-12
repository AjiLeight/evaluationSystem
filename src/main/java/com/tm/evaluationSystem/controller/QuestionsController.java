package com.tm.evaluationSystem.controller;

import com.tm.evaluationSystem.dto.QuestionsDTO;
import com.tm.evaluationSystem.repository.QuestionsRepository;
import com.tm.evaluationSystem.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/questions")
public class QuestionsController {
    private final QuestionsService questionsService;
    @GetMapping
    public ResponseEntity<List<QuestionsDTO>> findAllQuestions(){
        return ResponseEntity.ok(questionsService.findAllQuestions());
    }
}
