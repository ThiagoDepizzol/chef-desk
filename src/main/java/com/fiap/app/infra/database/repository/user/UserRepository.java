package com.fiap.app.infra.database.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.app.infra.database.entity.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, //
            value = "select users.* " + //
                    "from usr_users users " + //
                    "where users.active = true ")
    Page<UserEntity> findAllActive(Pageable pageable);

}
