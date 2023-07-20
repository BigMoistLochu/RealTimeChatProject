package com.example.realtimechatproject.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginForm {


    private String login;
    private String haslo;

    public LoginForm(){}

    public LoginForm(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }
}
