package com.example.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequest {
    String toEmailAddress;
    String message;
}
