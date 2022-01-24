package com.coderscampus.sorting;

import java.time.LocalDate;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private LocalDate lastLogin;

    public User(Integer userId, String username, String password, LocalDate lastLogin) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", lastLogin="
                + lastLogin + "]";
    }
}
