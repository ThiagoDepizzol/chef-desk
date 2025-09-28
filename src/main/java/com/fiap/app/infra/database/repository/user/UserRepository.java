package com.fiap.app.infra.database.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.app.infra.database.entity.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
