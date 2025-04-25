package com.order_online.user_service.config.security;

import com.order_online.user_service.port.output.PasswordEncoderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder implements PasswordEncoderPort {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public String encode(String password) {
        System.out.println("Entrei no encoder");
        System.out.println(password);
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String passwordTarget, String userPassword) {
        return encoder.matches(passwordTarget, userPassword);
    }
}
