package com.example.customer.controller;

import com.example.customer.dto.UserRequest;
import com.example.customer.dto.UserResponse;
import com.example.customer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/user")
    public UserResponse registerUser(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest);
    }
}
