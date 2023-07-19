package com.example.realtimechatproject.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Form {


    private String login;
    private String haslo;

    public Form(){}

    public Form(String login,String haslo) {
        this.login = login;
        this.haslo = haslo;
    }
}
