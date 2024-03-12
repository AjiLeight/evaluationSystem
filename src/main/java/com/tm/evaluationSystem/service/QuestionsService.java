package com.tm.evaluationSystem.service;

import com.tm.evaluationSystem.dto.AnswerOptionsDTO;
import com.tm.evaluationSystem.dto.QuestionsDTO;
import com.tm.evaluationSystem.model.Question;
import com.tm.evaluationSystem.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionsService {
    private final QuestionsRepository questionsRepository;
    public List<QuestionsDTO> findAllQuestions(){
        List<Question> questionsDBInfo = questionsRepository.findAll();
        return questionsDBInfo.stream()
                .map(this::mapQuestionsToQuestionsDTO)
                .toList();
    }

    private QuestionsDTO mapQuestionsToQuestionsDTO(Question question){
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
}
