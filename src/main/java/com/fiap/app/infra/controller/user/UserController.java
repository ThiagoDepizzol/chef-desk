package com.fiap.app.infra.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.app.core.domain.user.User;
import com.fiap.app.infra.controller.user.json.UserJson;
import com.fiap.app.infra.controller.user.mapper.UserMapper;
import com.fiap.app.infra.service.user.UserService;

@RestController
@RequestMapping("/usr/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserMapper userMapper;

    private final UserService userService;

    public UserController(final UserMapper userMapper, final UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> created(@RequestBody final UserJson json) {

        log.info("POST -> /usr/users -> {}", json);

        final User user = userMapper.map(json);

        return ResponseEntity.ok(userService.save(user));

    }

}
