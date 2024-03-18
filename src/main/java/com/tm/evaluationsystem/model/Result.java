package com.tm.evaluationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("result")
public class Result {
    @Id
    private String id;

    private String userid;
    private List<QuestionAnswerMap> questionAnswerMaps;
    private int attemptedQuestions;
    private int rightAnswers;
    private int percentage;
    private boolean isPassed;
}
