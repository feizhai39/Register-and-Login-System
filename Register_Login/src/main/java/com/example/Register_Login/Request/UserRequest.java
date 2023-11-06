package com.example.Register_Login.Request;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {
    Long id;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    String avatar;
    public String getAvatar(){
        return avatar;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String email;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    public String getPassword() {
        return password;
    }
}
