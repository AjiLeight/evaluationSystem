package com.tm.evaluationsystem.controller;

import com.tm.evaluationsystem.dto.UserSaveDTO;
import com.tm.evaluationsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @PostMapping
    private ResponseEntity<String> saveUser(@RequestBody UserSaveDTO userSaveDTO){
        return ResponseEntity.ok(userService.saveUser(userSaveDTO));
    }
}
