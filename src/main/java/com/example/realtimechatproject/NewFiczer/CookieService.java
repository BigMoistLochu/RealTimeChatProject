package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.HashingEmail;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public boolean checkCookie(HttpServletRequest request)
    {
        Map<String,String> mapOfCookie = new HashMap<>();
        Arrays.stream(request.getCookies())
                .map(cookie -> mapOfCookie.put(cookie.getName(),cookie.getValue()));
        if(mapOfCookie.get("ID_SESSION").equals("notLogged"))
            return false;

        return true;
    }




}
