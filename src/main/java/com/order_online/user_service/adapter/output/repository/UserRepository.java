package com.order_online.user_service.adapter.output.repository;

import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.output.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepositoryPort {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Override
    public UserModel saveUser(UserModel user) {
        return null;
    }

    @Override
    public UserModel findById(String id) {
        return null;
    }
}
