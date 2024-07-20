package com.example.customer.client;

import com.example.customer.dto.EmailRequest;
import com.example.customer.dto.EmailResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "emailService", url = "http://localhost:8080")
public interface EmailClient {
    @PostMapping("/email")
    @Retry(name = "emailRetry", fallbackMethod = "handleError")
    @Async
    @CircuitBreaker(name = "emailCircuitBreaker", fallbackMethod = "serviceFallbackMethod")
    ResponseEntity<EmailResponse> sendEmail(EmailRequest emailRequest);

    default ResponseEntity<EmailResponse> handleError(Throwable throwable){
        System.out.println("RT : Pushing payload to DLQ");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    default ResponseEntity<EmailResponse> serviceFallbackMethod(Throwable throwable){
        System.out.println("CB : Pushing payload to DLQ");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
