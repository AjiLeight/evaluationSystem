package com.tm.evaluationsystem.controller;

import com.tm.evaluationsystem.dto.AnswerRequestDTO;
import com.tm.evaluationsystem.dto.ResultResponseDTO;
import com.tm.evaluationsystem.service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answer")
@RequiredArgsConstructor
@CrossOrigin

public class AnswerController {
    private final AnswerService answerService;
    @PostMapping
    @Operation(summary = "Submits answers")
    private ResponseEntity<String> submitAnswer(@RequestBody AnswerRequestDTO answerRequestDTO){
        return ResponseEntity.ok(answerService.submitAnswer(answerRequestDTO));
    }
    @PutMapping
    private ResponseEntity<String> updateAnswer(@RequestBody AnswerRequestDTO answerRequestDTO){
        return ResponseEntity.ok(answerService.updateAnswer(answerRequestDTO));
    }
    @DeleteMapping
    private ResponseEntity<String> deleteAnswer(@RequestBody AnswerRequestDTO answerRequestDTO){
        return ResponseEntity.ok(answerService.deleteAnswer(answerRequestDTO));
    }
    @GetMapping("/{userId}")
    private ResponseEntity<ResultResponseDTO> getResultByUserId(@PathVariable String userId){
        return ResponseEntity.ok(answerService.getResultByUserId(userId));
    }
}
