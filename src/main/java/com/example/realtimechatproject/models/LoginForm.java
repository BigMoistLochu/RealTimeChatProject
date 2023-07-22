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

    private String name;

    private String username;

    public LoginForm(){}

    public LoginForm(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public LoginForm(String login, String haslo, String name, String username) {
        this.login = login;
        this.haslo = haslo;
        this.name = name;
        this.username = username;
    }
}
