package com.tm.evaluationsystem.repository;

import com.tm.evaluationsystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
