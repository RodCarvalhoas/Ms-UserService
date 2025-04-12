package com.order_online.user_service.adapter.input.transport;

import com.order_online.user_service.domain.model.UserRole;
import jakarta.validation.constraints.*;

public record CreateUserRequest(
        @NotBlank
        @Size(max = 20)
        String name,
        @Email
        String email,
        @NotBlank()
        @Size(min = 6, max = 20)
        String password,

        @NotNull
        UserRole userRole
) {
}
