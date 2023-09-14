package com.example.realtimechatproject.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String login;

    private String haslo;

    private String name;

    private String surname;

    private String token;



    public UserEntity(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public UserEntity(String login, String haslo,String name,String surname,String token) {
        this.login = login;
        this.haslo = haslo;
        this.name = name;
        this.surname = surname;
        this.token = token;
    }

    public UserEntity() {}

    @Transient
    public static UserEntityDto builder()
    {
        return new UserEntityDto();
    }


}
