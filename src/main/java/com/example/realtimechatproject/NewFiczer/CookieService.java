package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.services.restControllersServices.UserService;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CookieService{

    private static Cookie cookie = new Cookie("ID_SESSION","abc12345temporaryvalue");

    UserService userService;
    @Autowired
    public CookieService(UserService userService)
    {
        this.userService = userService;
    }
    public Cookie getCookieAuth(String email)
    {
        if(userService.isUserExists(email))
        {
            cookie.setValue(userService.getUserByLogin(email).getToken());
        }

        return cookie;
    }





    //co ta klasa ma robic?
    //klasa ma za zadanie tworzyc ciastko na podstwie loginu ktory jest zahashowany

}
