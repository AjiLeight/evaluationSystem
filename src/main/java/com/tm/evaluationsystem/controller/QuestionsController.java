package com.tm.evaluationsystem.controller;

import com.tm.evaluationsystem.dto.QuestionsRequestDTO;
import com.tm.evaluationsystem.dto.QuestionsResponseDTO;
import com.tm.evaluationsystem.exception.SectionNotFoundException;
import com.tm.evaluationsystem.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/questions")
@CrossOrigin
public class QuestionsController {
    private final QuestionsService questionsService;
    @GetMapping
    public ResponseEntity<List<QuestionsResponseDTO>> findAllQuestions(){
        return ResponseEntity.ok(questionsService.findAllQuestions());
    }

    @GetMapping("/{sectionId}")
    public ResponseEntity<List<QuestionsResponseDTO>> findAllQuestionsBySectionId(@PathVariable String sectionId){
        return ResponseEntity.ok(questionsService.findAllQuestionsBySectionId(sectionId));
    }

    @PostMapping("/{sectionId}")
    public ResponseEntity<String> createQuestionBySectionId(@RequestBody QuestionsRequestDTO requestDTO, @PathVariable String sectionId) throws SectionNotFoundException {
        questionsService.createQuestionBySectionId(requestDTO, sectionId);
        return ResponseEntity.ok("successfully saved " + requestDTO.toString() + " on " + sectionId);
    }

    @PutMapping("/{sectionId}")
    public ResponseEntity<QuestionsResponseDTO> updateQuestionBySectionId(@RequestBody QuestionsRequestDTO requestDTO, @PathVariable String sectionId){
        return ResponseEntity.ok(questionsService.updateQuestionBySectionid(requestDTO, sectionId));
    }

    @DeleteMapping
    public ResponseEntity<QuestionsResponseDTO> deleteQuestionBySectionId(@RequestParam String sectionId, @RequestParam String questionId){
        return ResponseEntity.ok(questionsService.deleteQuestionBySectionid(sectionId, questionId));
    }
}
