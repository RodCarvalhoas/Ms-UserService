package com.order_online.user_service.adapter.input.transport;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @Email
        String email,
        @NotBlank()
        String password
) {
}
