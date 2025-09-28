package com.fiap.app.infra.service.user;

import org.springframework.stereotype.Service;

import com.fiap.app.core.domain.user.User;
import com.fiap.app.core.gateway.UserGateway;
import com.fiap.app.core.usecase.UserUseCase;

@Service
public class UserService {

    private final UserUseCase userUseCase;

    public UserService(final UserGateway userGateway) {
        this.userUseCase = new UserUseCase(userGateway);
    }

    public User save(final User user) {

        return userUseCase.save(user);
    }

}
