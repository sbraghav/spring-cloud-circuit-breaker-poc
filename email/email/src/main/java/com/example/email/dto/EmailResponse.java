package com.example.email.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailResponse {
    String status;
    String message;
}
