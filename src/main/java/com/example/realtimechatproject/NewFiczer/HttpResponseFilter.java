package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.models.LoginForm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

public class HttpResponseFilter {

    private HttpServletResponse httpServletResponse;
    private Model model;
    private LoginForm loginForm;

    public HttpServletResponse build()
    {
        return httpServletResponse;
    }

    public static HttpResponseFilter buildResponse()
    {
        return new HttpResponseFilter();
    }




    public HttpResponseFilter setHttpResponse(HttpServletResponse httpServletResponse)
    {
        this.httpServletResponse = httpServletResponse;
        Cookie cookie = new Cookie("xd","frajer");
        httpServletResponse.addCookie(cookie);
        String login = "login.html";
        httpServletResponse.setContentType(login);
        return this;
    }

    public HttpResponseFilter setModel(Model model)
    {
        this.model = model;
        //zamiast tutaj to ustawiac to ustawimy to:
        model.addAttribute("infoForUser","Login or Password is valid");
        model.addAttribute("LoginForm", new LoginForm());
        return this;
    }

    public HttpResponseFilter setLoginForm(LoginForm loginForm)
    {
        this.loginForm = loginForm;
        return this;
    }



//    public static ResponseDto buildResponse()
//    {
//        return new ResponseDto();
//    }




}
