package com.work.entities;

import com.work.entities.enums.Role;

public class User {
    private static int id_starter = 1;
    private int id;
    private String username;
    private String email;
    private String password;
    private Role role;

    public User(int id, String username, String email, String password) {
        this.id = id_starter++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public int getId_starter() {
        return id_starter;
    }



    public int getId() {
        return id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}