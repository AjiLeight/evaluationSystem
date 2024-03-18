package com.tm.evaluationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOptionsDTO {
    private int id;
    private String answer;
    private Boolean isRight;
}
