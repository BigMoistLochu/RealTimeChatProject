package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.RegisterForm;
import com.example.realtimechatproject.models.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

public class ResponseDto {

    private HttpServletResponse httpServletResponse;

    private Model model;
    private LoginForm loginForm;


    public ResponseDto setHttpResponse(HttpServletResponse httpServletResponse)
    {
        this.httpServletResponse = httpServletResponse;
        Cookie cookie = new Cookie("xd","frajer");
        httpServletResponse.addCookie(cookie);
        String login = "login.html";
        httpServletResponse.setContentType(login);
        return this;
    }

    public ResponseDto setModel(Model model)
    {
        this.model = model;
        //zamiast tutaj to ustawiac to ustawimy to:
        model.addAttribute("infoForUser","Login or Password is valid");
        model.addAttribute("LoginForm", new LoginForm());
        return this;
    }

    public ResponseDto setLoginForm(LoginForm loginForm)
    {
        this.loginForm = loginForm;
        return this;
    }

    public HttpServletResponse build()
    {
        return httpServletResponse;
    }


}
