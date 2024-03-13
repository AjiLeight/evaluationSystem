package com.tm.evaluationSystem.controller;

import com.tm.evaluationSystem.dto.AddSectionDTO;
import com.tm.evaluationSystem.dto.DeleteSectionDTO;
import com.tm.evaluationSystem.dto.GetAllSectionsDTO;
import com.tm.evaluationSystem.dto.UpdateSectionDTO;
import com.tm.evaluationSystem.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    @GetMapping
    private ResponseEntity<GetAllSectionsDTO> getAllSections(){
        return null;
    }

    @PostMapping("/{sectionName}")
    private ResponseEntity<AddSectionDTO> addSection(@PathVariable String sectionName){
        return ResponseEntity.ok(sectionService.addSection(sectionName));
    }

    @PutMapping("/{sectionId}")
    private ResponseEntity<UpdateSectionDTO> updateSectionById(@PathVariable String sectionId){
        return null;
    }

    @DeleteMapping("/{sectionId}")
    private ResponseEntity<DeleteSectionDTO> deleteSectionById(@PathVariable String sectionId){
        return null;
    }
}
