package com.tm.evaluationsystem.controller;

import com.tm.evaluationsystem.dto.ResultResponseDTO;
import com.tm.evaluationsystem.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/result")
@RequiredArgsConstructor
@CrossOrigin
public class ResultController {
    private final ResultService resultService;
    @GetMapping("/{userId}")
    private ResponseEntity<ResultResponseDTO> getResultByUserId (@PathVariable String userId){
        return ResponseEntity.ok(resultService.getResultByUserId(userId));
    }
}
