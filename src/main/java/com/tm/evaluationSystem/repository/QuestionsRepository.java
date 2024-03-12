package com.tm.evaluationSystem.repository;

import com.tm.evaluationSystem.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends MongoRepository<Question, String> {
}
