package com.tm.evaluationsystem.dto;

import com.tm.evaluationsystem.model.QuestionAnswerMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponseDTO {
    private String id;

    private String userid;
    private List<QuestionAnswerMap> questionAnswerMaps;
    private int attemptedQuestions;
    private int rightAnswers;
    private float percentage;
    private boolean isPassed;
}
