package com.fiap.app.infra.service.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiap.app.core.domain.user.User;
import com.fiap.app.core.gateway.UserGateway;
import com.fiap.app.core.usecase.UserUseCase;

import jakarta.validation.constraints.NotNull;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserUseCase userUseCase;

    public UserService(final UserGateway userGateway) {
        this.userUseCase = new UserUseCase(userGateway);
    }

    public User save(final User user) {

        return userUseCase.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(@NotNull final Long id) {

        log.info("findById -> {}", id);

        return userUseCase.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(final int page, final int size) {

        log.info("findAll");

        return userUseCase.findAll(page, size);
    }

}
