package com.example.realtimechatproject.services.cookieService;

import com.example.realtimechatproject.models.User;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import lombok.AllArgsConstructor;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CookieServiceTest {

    @BeforeClass
    public static void setup() {
        //table of Users
        User user = new User("ape@wp.pl","mati12345","Konrad","Pasiak","412nsd7dc");
    }


    @Test
    void injectCookieToUserShouldReturnCookieWithValueNotLogged() {


    }
}