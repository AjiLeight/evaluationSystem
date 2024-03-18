package com.tm.evaluationsystem.repository;

import com.tm.evaluationsystem.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {
}
