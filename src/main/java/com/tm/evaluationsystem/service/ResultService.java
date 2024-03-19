package com.tm.evaluationsystem.service;

import com.tm.evaluationsystem.dto.ResultResponseDTO;
import com.tm.evaluationsystem.model.Result;
import com.tm.evaluationsystem.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final MongoTemplate mongoTemplate;
    public ResultResponseDTO getResultByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userid").is(userId));
        Result result = mongoTemplate
                .find(query, Result.class)
                .stream().findFirst()
                .orElseThrow();
        return mapResultToResultResponseDTO(result);
    }

    private static ResultResponseDTO mapResultToResultResponseDTO(Result result) {
        return ResultResponseDTO.builder()
                .id(result.getId())
                .userid(result.getUserid())
                .attemptedQuestions(result.getAttemptedQuestions())
                .rightAnswers(result.getRightAnswers())
                .questionAnswerMaps(result.getQuestionAnswerMaps())
                .isPassed(result.isPassed())
                .percentage(result.getPercentage())
                .build();
    }
}
