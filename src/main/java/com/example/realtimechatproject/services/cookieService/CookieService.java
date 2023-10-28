package com.example.realtimechatproject.services.cookieService;

import com.example.realtimechatproject.services.restControllersServices.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CookieService {

    UserService userService;


    public boolean checkCookieSessionId(HttpServletRequest request)
    {

        Map<String,String> mapOfCookie = new HashMap<>();

        Arrays.stream(request.getCookies()).forEach(cookie -> mapOfCookie.put(cookie.getName(),cookie.getValue()));

        if(mapOfCookie.get("ID_SESSION").equals("notLogged"))
            return false;
        else
        {
            if(userService.isTokenExists(mapOfCookie.get("ID_SESSION")))
            {
                return true;
            }
        }
        return false;
    }

    public Cookie injectCookieToUser(String login)
    {
        if(userService.isUserExists(login))
        {
            String userToken = userService.getUserByLogin(login).getToken();
            Cookie cookie = new Cookie("ID_SESSION", userToken);
            cookie.setMaxAge(120);
            System.out.println("ciastko wcisniete do uzytkownika po zalogowaniu na 120 sekund "+cookie.getValue());
            return cookie;
        }
        return new Cookie("ID_SESSION","notLogged");
    }






}
