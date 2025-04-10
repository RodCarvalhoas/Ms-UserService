package com.order_online.user_service.adapter.input.transport;

public record CreateUserResponse(
        String id,
        String name,
        String email
) {
}
