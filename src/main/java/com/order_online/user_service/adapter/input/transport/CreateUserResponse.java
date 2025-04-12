package com.order_online.user_service.adapter.input.transport;

import com.order_online.user_service.domain.model.UserRole;

public record CreateUserResponse(
        String id,
        String name,
        String email,

        UserRole userRole
) {
}
