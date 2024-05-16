package com.coderscampus.assignment3;

public class User {

    String username;
    String password;
    String name;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}