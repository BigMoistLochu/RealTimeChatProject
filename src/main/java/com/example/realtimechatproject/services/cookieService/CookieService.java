package com.example.realtimechatproject.services.cookieService;

import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.HashingEmail;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class CookieService {

    UserService userService;




    public boolean checkCookie(HttpServletRequest request)
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
            System.out.println("ciastko wcisniete do uzytkownika po zalogowaniu "+cookie.getValue());
            return cookie;
        }
        return new Cookie("ID_SESSION","notLogged");
    }



    //za kazdym razem sprawdzane jesy ciastko czy uzytkownik jesy zalogowany
    //user uderza na endpoint




}
