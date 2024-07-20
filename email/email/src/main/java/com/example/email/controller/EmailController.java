package com.example.email.controller;

import com.example.email.dto.EmailRequest;
import com.example.email.dto.EmailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EmailController {
    @PostMapping("/email")
    public ResponseEntity sendEmail(@RequestBody EmailRequest emailRequest){
        log.info("Sent email {} to {}", emailRequest.getMessage(), emailRequest.getToEmailAddress());
        return new ResponseEntity(HttpStatus.OK);
//        return EmailResponse.builder().status("Success").message("Email Delivered successfully").build();
    }

}
