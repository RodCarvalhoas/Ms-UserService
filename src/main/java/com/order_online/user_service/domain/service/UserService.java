package com.order_online.user_service.domain.service;

import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.input.UserServicePort;
import com.order_online.user_service.port.output.PasswordEncoderPort;
import com.order_online.user_service.port.output.TokenServicePort;
import com.order_online.user_service.port.output.UserRepositoryPort;

public class UserService implements UserServicePort {

    private UserRepositoryPort userRepositoryPort;

    private PasswordEncoderPort passwordEncoderPort;

    private TokenServicePort tokenServicePort;

    public UserService(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort, TokenServicePort tokenServicePort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
        this.tokenServicePort = tokenServicePort;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        String encryptedPassword = passwordEncoderPort.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return this.userRepositoryPort.saveUser(user);
    }

    @Override
    public UserModel findByEmail(String email) {
        return this.userRepositoryPort.findByEmail(email);
    }

    @Override
    public String login(String email, String password) {
        UserModel user = this.findByEmail(email);
        if(user == null || !passwordEncoderPort.matches(password, user.getPassword()))
            throw new RuntimeException("Credenciais inválidas");

        return tokenServicePort.generateToken(user);
    }
}
