package com.tm.evaluationSystem.service;

import com.tm.evaluationSystem.dao.UserDao;
import com.tm.evaluationSystem.dto.UserSaveDTO;
import com.tm.evaluationSystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    public String saveUser(UserSaveDTO userSaveDTO){
        User user = User.builder()
                .email(userSaveDTO.getEmail())
                .name(userSaveDTO.getName())
                .regNo(userSaveDTO.getRegNo())
                .build();
        return userDao.saveUser(user).getUniqueId();
    }
}
