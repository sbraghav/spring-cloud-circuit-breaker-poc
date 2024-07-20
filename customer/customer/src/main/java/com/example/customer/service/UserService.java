package com.example.customer.service;

import com.example.customer.client.EmailClient;
import com.example.customer.dto.EmailRequest;
import com.example.customer.dto.UserRequest;
import com.example.customer.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final EmailClient emailClient;
    public UserResponse registerUser(UserRequest userRequest) {
        EmailRequest emailRequest = EmailRequest.builder().message(userRequest.getName()).toEmailAddress(userRequest.getEmail()).build();
        emailClient.sendEmail(emailRequest);
        return UserResponse.builder().name(userRequest.getName()).email(userRequest.getEmail()).build();
    }
}
