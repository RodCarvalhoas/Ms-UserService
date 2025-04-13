package com.order_online.user_service.adapter.input.controllers;

import com.order_online.user_service.adapter.input.transport.CreateUserRequest;
import com.order_online.user_service.adapter.input.transport.CreateUserResponse;
import com.order_online.user_service.adapter.input.transport.LoginRequest;
import com.order_online.user_service.adapter.input.transport.LoginResponse;
import com.order_online.user_service.adapter.utils.UserMapper;
import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.input.UserServicePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserServicePort userServicePort;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserModel userCreated = this.userServicePort.saveUser(userMapper.toDomain(request));
        URI uri = ServletUriComponentsBuilder.fromPath("/{id}").buildAndExpand(userCreated.getId()).toUri();

        return ResponseEntity.created(uri).body(userMapper.toCreateUserResponse(userCreated));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        String token = this.userServicePort.login(request.email(), request.password());

        return ResponseEntity.ok(new LoginResponse(token));
    }

}
