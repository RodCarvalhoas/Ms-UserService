package com.order_online.user_service.domain.service;

import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.input.UserServicePort;
import com.order_online.user_service.port.output.UserRepositoryPort;

public class UserService implements UserServicePort {

    private UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return null;
    }

    @Override
    public UserModel findById(String id) {
        return null;
    }
}
