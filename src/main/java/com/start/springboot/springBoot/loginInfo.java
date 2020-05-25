package com.start.springboot.springBoot;

import org.springframework.stereotype.Component;

@Component
public class loginInfo {
    public loginInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    String email;
    String password;

    public loginInfo() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
