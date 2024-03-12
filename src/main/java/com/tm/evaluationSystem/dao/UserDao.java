package com.tm.evaluationSystem.dao;

import com.tm.evaluationSystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final MongoTemplate mongoTemplate;
    public User saveUser(User user){
        return mongoTemplate.save(user);
    }
}
