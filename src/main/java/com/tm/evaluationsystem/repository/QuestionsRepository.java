package com.tm.evaluationsystem.repository;

import com.tm.evaluationsystem.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends MongoRepository<Question, String> {
}
