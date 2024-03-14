package com.tm.evaluationSystem.controller;

import com.tm.evaluationSystem.dto.QuestionsDTO;
import com.tm.evaluationSystem.exception.SectionNotFoundException;
import com.tm.evaluationSystem.repository.QuestionsRepository;
import com.tm.evaluationSystem.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{sectionId}")
    public ResponseEntity<List<QuestionsDTO>> findAllQuestionsBySectionId(@PathVariable String sectionId){
        return ResponseEntity.ok(questionsService.findAllQuestionsBySectionId(sectionId));
    }

    @PostMapping("/{sectionId}")
    public ResponseEntity<String> createQuestionBySectionId(@RequestBody QuestionsDTO questionsDTO, @PathVariable String sectionId) throws SectionNotFoundException {
        questionsService.createQuestionBySectionId(questionsDTO, sectionId);
        return ResponseEntity.ok("successfully saved " + questionsDTO.toString() + " on " + sectionId);
    }

    @PutMapping("/{sectionId}")
    public ResponseEntity<QuestionsDTO> updateQuestionBySectionId(@RequestBody QuestionsDTO questionsDTO, @PathVariable String sectionId){
        return ResponseEntity.ok(questionsService.updateQuestionBySectionid(questionsDTO, sectionId));
    }

    @DeleteMapping
    public ResponseEntity<QuestionsDTO> deleteQuestionBySectionId(@RequestParam String sectionId, @RequestParam String questionId){
        return ResponseEntity.ok(questionsService.deleteQuestionBySectionid(sectionId, questionId));
    }
}
