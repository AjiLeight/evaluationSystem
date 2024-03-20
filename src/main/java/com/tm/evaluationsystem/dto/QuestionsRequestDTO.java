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
public class QuestionsRequestDTO {
    private String question;
    private List<AnswerOptionsRequestDTO> answerOptions;
}
