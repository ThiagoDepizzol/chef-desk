package com.fiap.app.infra.gateway.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Override
    public Optional<User> findById(final Long id) {

        final Optional<UserEntity> entity = userRepository.findById(id);

        return entity.map(userMapper::map);

    }

    @Override
    public List<User> findAll(final int page, final int size) {

        final Pageable pageable = PageRequest.of(page, size);

        final Page<UserEntity> userEntities = userRepository.findAllActive(pageable);

        return userEntities
                .stream()
                .map(userMapper::map)
                .toList();

    }

}
