package com.tm.evaluationSystem.dto;

import com.tm.evaluationSystem.model.Answer;
import jakarta.annotation.Nonnull;
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
    private String id;
    @Nonnull
    private String question;
    @Nonnull
    private List<AnswerOptionsDTO> answerOptions;
}
