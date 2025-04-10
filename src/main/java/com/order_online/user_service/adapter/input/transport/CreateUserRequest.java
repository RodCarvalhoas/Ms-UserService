package com.order_online.user_service.adapter.input.transport;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank
        @Max(20)
        String name,
        @Email
        String email,
        @NotBlank()
        @Min(6)
        @Max(20)
        String password
) {
}
