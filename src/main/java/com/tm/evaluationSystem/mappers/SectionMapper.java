package com.tm.evaluationSystem.mappers;

import com.tm.evaluationSystem.dto.SectionDTO;
import com.tm.evaluationSystem.model.Section;

public class SectionMapper {
    public static Section mapSectionDTOToSection(SectionDTO source){
        return Section.builder()
                .name(source.getName())
                .id(source.getId())
                .questions(source.getQuestions())
                .build();
    }

    public static SectionDTO mapSectionToSectionDTO(Section source){
        return SectionDTO.builder()
                .name(source.getName())
                .questions(source.getQuestions())
                .id(source.getId())
                .build();
    }
}
