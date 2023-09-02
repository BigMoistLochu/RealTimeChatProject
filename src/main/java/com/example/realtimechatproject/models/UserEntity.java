package com.example.realtimechatproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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



    public UserEntity(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public UserEntity() {}
}
