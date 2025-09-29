package com.fiap.app.core.usecase;

import java.util.Optional;

import com.fiap.app.core.domain.user.User;
import com.fiap.app.core.gateway.UserGateway;

public class UserUseCase {

    private final UserGateway userGateway;

    public UserUseCase(final UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User save(final User user) {

        return userGateway.save(user);
    }

    public Optional<User> findById(final Long id) {

        return userGateway.findById(id);
    }

}
