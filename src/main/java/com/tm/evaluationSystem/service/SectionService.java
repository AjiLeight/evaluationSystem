package com.tm.evaluationSystem.service;

import com.tm.evaluationSystem.dto.AddSectionDTO;
import com.tm.evaluationSystem.model.Section;
import com.tm.evaluationSystem.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;

    public AddSectionDTO addSection(String sectionName){
        Section section = Section.builder()
                .name(sectionName)
                .build();
        Section savedSection = sectionRepository.save(section);
        return AddSectionDTO.builder()
                .id(savedSection.getId())
                .name(savedSection.getName())
                .build();
    }
}
