package com.tm.evaluationSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("section")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {
    @Id
    private String id;

    private String name;
    private List<Question> questions;
}
