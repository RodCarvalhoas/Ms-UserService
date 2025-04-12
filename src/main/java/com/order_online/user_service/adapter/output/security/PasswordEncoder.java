package com.order_online.user_service.adapter.output.security;

import com.order_online.user_service.port.output.PasswordEncoderPort;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordEncoder implements PasswordEncoderPort {

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder encoder;

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }
}
