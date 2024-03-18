package com.tm.evaluationsystem.dao;

import com.tm.evaluationsystem.model.Question;
import com.tm.evaluationsystem.model.Section;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class QuestionsDao {
    private final MongoTemplate mongoTemplate;

    public List<Question> getAllQuestionsBySectionId(String sectionId){
        return Objects.requireNonNull(mongoTemplate
                        .findById(sectionId, Section.class))
                .getQuestions();
    }
}
