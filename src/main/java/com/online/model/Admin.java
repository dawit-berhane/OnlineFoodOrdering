package com.online.model;

public class Admin {
    private static String password;
    private static String username;

    static {
        password = "password";
        username = "admin";
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
