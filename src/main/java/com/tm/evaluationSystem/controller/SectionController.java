package com.tm.evaluationSystem.controller;

import com.tm.evaluationSystem.dto.SectionDTO;
import com.tm.evaluationSystem.dto.DeleteSectionDTO;
import com.tm.evaluationSystem.dto.UpdateSectionDTO;
import com.tm.evaluationSystem.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sections")
@RequiredArgsConstructor
public class SectionController {
//    TODO: make this a interface-impl

    private final SectionService sectionService;
    @GetMapping
    private ResponseEntity<List<SectionDTO>> getAllSections(){
        return ResponseEntity.ok(sectionService.getAllSectionsDTO());
    }

    @PostMapping("/{sectionName}")
    private ResponseEntity<SectionDTO> addSection(@PathVariable String sectionName){
        return ResponseEntity.ok(sectionService.addSection(sectionName));
    }

    @PutMapping("/{sectionId}")
    private ResponseEntity<UpdateSectionDTO> updateSectionById(@PathVariable String sectionId){
//        TODO: implement logic
        return null;
    }

    @DeleteMapping("/{sectionId}")
    private ResponseEntity<DeleteSectionDTO> deleteSectionById(@PathVariable String sectionId){
//        TODO: implement logic
        return null;
    }
}
