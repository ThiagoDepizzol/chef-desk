package com.fiap.app.infra.database.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity {

    private static final String TABLE_NAME = "usr_users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String login;

    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity(final String username, final String login, final String password) {
        this.username = username;
        this.login = login;
        this.password = password;
    }

}
