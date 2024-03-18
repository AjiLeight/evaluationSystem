package com.tm.evaluationsystem.mappers;

import com.tm.evaluationsystem.dto.AnswerOptionsDTO;
import com.tm.evaluationsystem.dto.QuestionsDTO;
import com.tm.evaluationsystem.model.Answer;
import com.tm.evaluationsystem.model.Question;
import com.tm.evaluationsystem.model.Section;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    public static QuestionsDTO mapQuestionsToQuestionsDTO(Question question){
        List<AnswerOptionsDTO> answers = question.getAnswerOptions()
                .stream()
                .map( answer -> AnswerOptionsDTO.builder()
                        .answer(answer.getAnswer())
                        .id(answer.getId())
                        .build()
                ).toList();
        return QuestionsDTO.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answerOptions(answers)
                .build();
    }

    public static Question mapQuestionsDTOToQuestions(QuestionsDTO question, String sectionid){
        Integer answerId = 0;
        List<Answer> answers = question.getAnswerOptions()
                .stream()
                .map( answer -> Answer.builder()
                        .answer(answer.getAnswer())
                        .id(generateAnswerid(answerId))
                        .isRight(answer.getIsRight())
                        .build()
                ).toList();
        return Question.builder()
                .question(question.getQuestion())
                .answerOptions(answers)
                .build();
    }


    private static int generateAnswerid(Integer answerId) {
        return answerId+=1;
    }


}
