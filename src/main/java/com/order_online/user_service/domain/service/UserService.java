package com.order_online.user_service.domain.service;

import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.input.UserServicePort;
import com.order_online.user_service.port.output.PasswordEncoderPort;
import com.order_online.user_service.port.output.UserRepositoryPort;

public class UserService implements UserServicePort {

    private UserRepositoryPort userRepositoryPort;

    private PasswordEncoderPort passwordEncoderPort;

    public UserService(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        String encryptedPassword = passwordEncoderPort.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return this.userRepositoryPort.saveUser(user);
    }

    @Override
    public UserModel findByEmail(String email) {
        return null;
    }
}
