package com.fiap.app.infra.gateway.user;

import com.fiap.app.core.domain.user.User;
import com.fiap.app.core.gateway.UserGateway;
import com.fiap.app.infra.controller.user.mapper.UserMapper;
import com.fiap.app.infra.database.entity.user.UserEntity;
import com.fiap.app.infra.database.repository.user.UserRepository;

public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserRepositoryGateway(final UserRepository userRepository, final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(final User user) {

        final UserEntity entity = userMapper.map(user);

        final UserEntity savedEntity = userRepository.save(entity);

        return userMapper.map(savedEntity);
    }

}
