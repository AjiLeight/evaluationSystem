package com.tm.evaluationsystem.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequestDTO {
    private String userId;
    private String sectionId;
    private int questionId;
    private int answerId;
}
