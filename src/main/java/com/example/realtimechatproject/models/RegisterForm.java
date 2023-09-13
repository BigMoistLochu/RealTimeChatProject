package com.example.realtimechatproject.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RegisterForm implements IForm{

    private String login;
    private String haslo;

    private String name;

    private String surname;





}
