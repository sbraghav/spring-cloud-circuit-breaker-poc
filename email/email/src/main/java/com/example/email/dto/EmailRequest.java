package com.example.email.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequest {
    String toEmailAddress;
    String message;
}
