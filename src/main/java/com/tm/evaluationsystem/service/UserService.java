package com.tm.evaluationsystem.service;

import com.tm.evaluationsystem.dao.UserDao;
import com.tm.evaluationsystem.dto.UserSaveDTO;
import com.tm.evaluationsystem.model.User;
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
