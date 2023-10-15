package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.HashingEmail;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CookieService {

    UserService userService;

    public Cookie getCookie(String login)
    {
        if(userService.isUserExists(login))
        {
            Cookie cookie  =new Cookie("ID_SESSION",HashingEmail.GenereteNewToken(login));
            cookie.setMaxAge(2000);
            return cookie;
        }

        return new Cookie("ID_SESSION","notLogged");
    }




}
