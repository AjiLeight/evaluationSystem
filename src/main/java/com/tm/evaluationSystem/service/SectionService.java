package com.tm.evaluationSystem.service;

import com.tm.evaluationSystem.dto.SectionDTO;
import com.tm.evaluationSystem.dto.GetAllSectionsDTO;
import com.tm.evaluationSystem.mappers.SectionMapper;
import com.tm.evaluationSystem.model.Section;
import com.tm.evaluationSystem.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.tm.evaluationSystem.mappers.SectionMapper.*;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class SectionService {
//    TODO: make this a interface-impl

    private final SectionRepository sectionRepository;

    public SectionDTO addSection(String sectionName){
        Section section = Section.builder()
                .name(sectionName)
                .build();
        Section savedSection = sectionRepository.save(section);
        return SectionDTO.builder()
                .id(savedSection.getId())
                .name(savedSection.getName())
                .build();
    }

    public List<SectionDTO> getAllSectionsDTO(){
        return sectionRepository
                .findAll()
                .stream().map(SectionMapper::mapSectionToSectionDTO)
                .toList();
    }
}
