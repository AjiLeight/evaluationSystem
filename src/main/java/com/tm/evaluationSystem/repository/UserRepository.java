package com.tm.evaluationSystem.repository;

import com.tm.evaluationSystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
