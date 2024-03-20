package com.tm.evaluationsystem.service;

import static com.tm.evaluationsystem.constants.GlobalConstants.SUCCESS_RESPONSE_STRING;
import static com.tm.evaluationsystem.constants.GlobalConstants.TOTAL_MARKS_COMMON;

import com.tm.evaluationsystem.dto.AnswerRequestDTO;
import com.tm.evaluationsystem.dto.ResultResponseDTO;
import com.tm.evaluationsystem.model.*;
import com.tm.evaluationsystem.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final ResultRepository resultRepository;
    private final MongoTemplate mongoTemplate;


    public String submitAnswer(AnswerRequestDTO answerRequestDTO) {
        Result existingResult = findResultByUserId(answerRequestDTO.getUserId());
        if(existingResult==null){
            existingResult = Result.builder()
                    .userid(answerRequestDTO.getUserId())
                    .attemptedQuestions(0)
                    .questionAnswerMaps(new ArrayList<>())
                    .rightAnswers(0)
                    .isPassed(false)
                    .percentage(0)
                    .build();
        }
        calculateNewResult(existingResult, answerRequestDTO);
        persistNewResult(existingResult);
        return SUCCESS_RESPONSE_STRING;
    }

    public void persistNewResult(Result existingResult) {
        resultRepository.save(existingResult);
    }

    private void calculateNewResult(Result existingResult, AnswerRequestDTO answerRequestDTO) {
        QuestionAnswerMap questionAnswerMap = QuestionAnswerMap.builder()
                                .questionId(answerRequestDTO.getQuestionId())
                                .answerId(answerRequestDTO.getAnswerId())
                                        .build();
        existingResult
                .getQuestionAnswerMaps()
                .add(questionAnswerMap);
        existingResult.setAttemptedQuestions(existingResult.getAttemptedQuestions()+1);
        Boolean isRightAnswer = checkRightAnswer(answerRequestDTO.getSectionId(), answerRequestDTO.getQuestionId(), answerRequestDTO.getAnswerId());
        if(isRightAnswer){
            existingResult.setRightAnswers(existingResult.getRightAnswers()+1);
            existingResult.setPercentage(calculateNewResultPercentage(existingResult.getRightAnswers()));
        }

    }

    private Boolean checkRightAnswer(String sectionId, int questionId, int answerId) {
        Section section = mongoTemplate.findById(sectionId, Section.class);
        if(section!=null && section.getQuestions()!=null && !section.getQuestions().isEmpty()) {
            Question question =  section
                    .getQuestions()
                    .stream().filter(questionFilter -> questionFilter.getId() == questionId)
                    .findFirst()
                    .orElseThrow();
            Answer existingAnswer = question
                    .getAnswerOptions()
                    .stream().filter(answer -> answer.getId()==answerId)
                    .findFirst()
                    .orElseThrow();
            return existingAnswer.getIsRight();
        }
        return false;
    }

    private float calculateNewResultPercentage(int rightAnswers) {
        return ((float)rightAnswers/TOTAL_MARKS_COMMON)*100;
    }

    private Result findResultByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<Result> results = mongoTemplate.find(query, Result.class);
        return results.stream().findFirst().orElse(null);
    }

    public String updateAnswer(AnswerRequestDTO answerRequestDTO) {
        //TODO: logic
        return null;
    }

    public String deleteAnswer(AnswerRequestDTO answerRequestDTO) {
        //TODO: logic
        return null;
    }

    public ResultResponseDTO getResultByUserId(String userId) {
        //TODO: logic
        return null;
    }
}
