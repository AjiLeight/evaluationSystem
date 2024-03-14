package com.tm.evaluationSystem.mappers;

import com.tm.evaluationSystem.dto.AnswerOptionsDTO;
import com.tm.evaluationSystem.dto.QuestionsDTO;
import com.tm.evaluationSystem.model.Answer;
import com.tm.evaluationSystem.model.Question;

import java.util.List;

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

    public static Question mapQuestionsDTOToQuestions(QuestionsDTO question){
        List<Answer> answers = question.getAnswerOptions()
                .stream()
                .map( answer -> Answer.builder()
                        .answer(answer.getAnswer())
                        .id(answer.getId())
                        .build()
                ).toList();
        return Question.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answerOptions(answers)
                .build();
    }


}
