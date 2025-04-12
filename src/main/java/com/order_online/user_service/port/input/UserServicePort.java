package com.order_online.user_service.port.input;

import com.order_online.user_service.domain.model.UserModel;

public interface UserServicePort {
    UserModel saveUser(UserModel user);

    UserModel findByEmail(String email);
    
    
}