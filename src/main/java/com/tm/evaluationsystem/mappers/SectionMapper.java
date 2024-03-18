package com.tm.evaluationsystem.mappers;

import com.tm.evaluationsystem.dto.SectionDTO;
import com.tm.evaluationsystem.model.Section;

public class SectionMapper {
    public static Section mapSectionDTOToSection(SectionDTO source){
        return Section.builder()
                .name(source.getName())
                .id(source.getId())
                .build();
    }

    public static SectionDTO mapSectionToSectionDTO(Section source){
        return SectionDTO.builder()
                .name(source.getName())
                .id(source.getId())
                .build();
    }
}
