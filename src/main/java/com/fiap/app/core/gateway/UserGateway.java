package com.fiap.app.core.gateway;

import java.util.Optional;

import com.fiap.app.core.domain.user.User;

public interface UserGateway {

    User save(final User user);

    Optional<User> findById(final Long id);

}
