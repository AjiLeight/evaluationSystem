package com.tm.evaluationsystem.dao;

import com.tm.evaluationsystem.model.User;
import lombok.RequiredArgsConstructor;
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
