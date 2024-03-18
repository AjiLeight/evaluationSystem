package com.tm.evaluationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsDTO {
    private int id;
    private String question;
    private List<AnswerOptionsDTO> answerOptions;
}
