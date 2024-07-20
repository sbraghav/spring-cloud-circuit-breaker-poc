package com.example.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    String name;
    String email;
}
