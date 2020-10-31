package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class Login {

    private String email;
    private String password;

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
