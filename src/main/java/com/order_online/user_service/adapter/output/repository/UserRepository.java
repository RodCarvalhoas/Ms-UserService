package com.order_online.user_service.adapter.output.repository;

import com.order_online.user_service.adapter.output.persistence.UserEntity;
import com.order_online.user_service.adapter.utils.UserMapper;
import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.output.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepositoryPort {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel saveUser(UserModel user) {
        UserEntity savedUser = userRepositoryJpa.save(this.userMapper.toEntity(user));
        return this.userMapper.toDomain(savedUser);
    }

    @Override
    public UserModel findByEmail(String email) {
        return userMapper.toDomain(userRepositoryJpa.findByEmail(email));
    }
}
