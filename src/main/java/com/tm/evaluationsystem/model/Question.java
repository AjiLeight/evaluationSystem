package com.tm.evaluationsystem.model;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
    @Id

    private int id;
    private String question;
    private List<Answer> answerOptions;
}
