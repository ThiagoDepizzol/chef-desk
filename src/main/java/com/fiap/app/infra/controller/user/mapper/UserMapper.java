package com.fiap.app.infra.controller.user.mapper;

import org.springframework.stereotype.Component;

import com.fiap.app.core.domain.user.User;
import com.fiap.app.infra.controller.user.json.UserJson;
import com.fiap.app.infra.database.entity.user.UserEntity;

@Component
public class UserMapper {

    public User map(final UserJson json) {
        return new User(json.getId(), json.getUsername(), json.getLogin(), json.getPassword());
    }

    public User map(final UserEntity entity) {
        return new User(entity.getId(), entity.getUsername(), entity.getLogin(), entity.getPassword());
    }

    public UserEntity map(final User user) {
        return new UserEntity(user.getUsername(), user.getLogin(), user.getPassword());
    }

}
