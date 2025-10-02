package com.fiap.app.infra.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.app.core.domain.user.User;
import com.fiap.app.infra.controller.user.json.UserJson;
import com.fiap.app.infra.controller.user.mapper.UserMapper;
import com.fiap.app.infra.service.user.UserService;

import org.springframework.transaction.annotation.Transactional;

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

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<User>> getAll(@RequestParam final int page, @RequestParam final int size) {

        log.info("GET -> /usr/users -> {}, {}", page, size);

        return ResponseEntity.ok(userService.findAll(page, size));
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<User> get(@PathVariable final Long id) {

        log.info("GET -> /usr/users/{id} -> {} ", id);

        return ResponseEntity.ok(userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
    }

    @PostMapping
    public ResponseEntity<User> created(@RequestBody final UserJson json) {

        log.info("POST -> /usr/users -> {}", json);

        final User user = userMapper.map(json);

        return ResponseEntity.ok(userService.save(user));

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable final Long id, @RequestBody final UserJson json) {

        log.info("PUT -> /usr/users -> {}, {}", id, json);

        final User user = userMapper.mapUpdate(json, id);

        return ResponseEntity.ok(userService.save(user));

    }

}
