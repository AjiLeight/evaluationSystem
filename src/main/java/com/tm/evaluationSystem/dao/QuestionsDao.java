package com.tm.evaluationSystem.dao;

import com.tm.evaluationSystem.model.Question;
import com.tm.evaluationSystem.model.Section;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
