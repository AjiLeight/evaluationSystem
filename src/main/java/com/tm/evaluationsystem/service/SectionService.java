package com.tm.evaluationsystem.service;

import com.tm.evaluationsystem.dto.SectionDTO;
import com.tm.evaluationsystem.mappers.SectionMapper;
import com.tm.evaluationsystem.model.Section;
import com.tm.evaluationsystem.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
