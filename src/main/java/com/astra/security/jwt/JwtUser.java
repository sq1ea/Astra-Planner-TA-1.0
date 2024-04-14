package com.astra.security.jwt;

public class JwtUser {
    private String username;
    private String password;

    public JwtUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public JwtUser() {
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
}
