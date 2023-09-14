package com.example.realtimechatproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UserEntityDto {


    private String login;

    private String haslo;

    private String name;

    private String surname;

    private String token;


    public UserEntityDto Login(String login)
    {
        this.login = login;
        return this;
    }

    public UserEntityDto Haslo(String haslo)
    {
        this.haslo = haslo;
        return this;
    }

    public UserEntityDto Name(String name)
    {
        this.name = login;
        return this;
    }

    public UserEntityDto Surname(String surname)
    {
        this.surname = surname;
        return this;
    }

    public UserEntityDto Token(String token)
    {
        this.token = token;
        return this;
    }

    public UserEntity build()
    {
        return new UserEntity(login,haslo,name,surname,token);
    }


}
