package com.fiap.app.core.domain.user;

public class User {

    private Long id;

    private String username;

    private String login;

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

    public User(final Long id, final String username, final String login, final String password) {
        this.id = id;
        this.username = username;
        this.login = login;
        this.password = password;
    }

}
