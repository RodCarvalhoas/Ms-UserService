package com.order_online.user_service.adapter.utils;

import com.order_online.user_service.adapter.input.transport.CreateUserRequest;
import com.order_online.user_service.adapter.input.transport.CreateUserResponse;
import com.order_online.user_service.adapter.output.persistence.UserEntity;
import com.order_online.user_service.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel toDomain(UserEntity entity);

    UserEntity toEntity(UserModel model);

    CreateUserResponse toCreateUserResponse(UserModel model);

    @Mapping(target = "id", ignore = true)
    UserModel toDomain(CreateUserRequest request);
}
