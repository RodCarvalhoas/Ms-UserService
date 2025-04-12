package com.order_online.user_service.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.order_online.user_service.adapter.output.persistence.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String SECRET;

    public String generateToken(UserEntity user) {
        Algorithm  algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create()
                .withIssuer("ORDER-ONLINE-MS-SERVICE")
                .withSubject(user.getEmail())
                .withClaim("id", user.getId().toString())
                .withExpiresAt(dateExpiresAt())
                .sign(algorithm);

    }

    public Date dateExpiresAt() {
        return Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
    }

    public DecodedJWT verifyToken(String token) {
        Algorithm  algorithm = Algorithm.HMAC256(SECRET);
        return JWT.require(algorithm).withIssuer("ORDER-ONLINE-MS-SERVICE").build().verify(token);
    }

    public String getSubject(String token) {
        return verifyToken(token).getSubject();
    }

}
