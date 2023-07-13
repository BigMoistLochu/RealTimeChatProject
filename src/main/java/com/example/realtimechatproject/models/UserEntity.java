package com.example.realtimechatproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String login;

    private String haslo;

    public UserEntity(String email, String login, String haslo) {
        this.email = email;
        this.login = login;
        this.haslo = haslo;
    }

    public UserEntity() {
    }
}
