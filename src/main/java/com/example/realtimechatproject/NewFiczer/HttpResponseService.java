package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.models.LoginForm;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Service;


public class HttpResponseService {

    private HttpResponseFilter httpResponseFilter;

    public HttpResponseService(HttpResponseFilter httpResponseFilter)
    {
        this.httpResponseFilter = httpResponseFilter;
    }

    public void CordinatorOfEverything()
    {
        Cookie cookie = new Cookie("CiastkoT","pedalsk");
        cookie.setMaxAge(1000);
        httpResponseFilter.getHttpServletResponse().addCookie(cookie);
        String login = "login.html";
        httpResponseFilter.getHttpServletResponse().setContentType(login);

        httpResponseFilter.getModel().addAttribute("infoForUser","Login or Password is valid");
        httpResponseFilter.getModel().addAttribute("LoginForm", new LoginForm());
    }

    public HttpResponseFilter getHttpResponseFilter() {
        return httpResponseFilter;
    }
}
