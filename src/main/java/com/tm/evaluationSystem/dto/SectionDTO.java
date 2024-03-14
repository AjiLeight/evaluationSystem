package com.tm.evaluationSystem.dto;

import com.tm.evaluationSystem.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectionDTO {
    private String id;
    private String name;
    private List<Question> questions;
}
