package com.order_online.user_service.config;

import com.order_online.user_service.adapter.output.repository.UserRepository;
import com.order_online.user_service.config.security.PasswordEncoder;
import com.order_online.user_service.config.security.TokenService;
import com.order_online.user_service.domain.service.UserService;
import com.order_online.user_service.port.output.PasswordEncoderPort;
import com.order_online.user_service.port.output.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserRepositoryPort userRepositoryPort() { return new UserRepository(); }

    @Bean
    public UserService userService() {
        return new UserService(userRepositoryPort(), passwordEncoderPort(), new TokenService());
    }

    @Bean
    public PasswordEncoderPort passwordEncoderPort() {
        return new PasswordEncoder();
    }
}
