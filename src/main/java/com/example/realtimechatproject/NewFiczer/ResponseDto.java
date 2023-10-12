package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.models.LoginForm;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

public class ResponseDto {

    private HttpServletResponse httpServletResponse;

    private Model model;
    private LoginForm loginForm;



    public ResponseDto setConfigurationResponse()
    {

        return this;
    }
    public HttpServletResponse build()
    {
        return httpServletResponse;
    }
    public ResponseDto setHttpResponse(HttpServletResponse httpServletResponse)
    {
        this.httpServletResponse = httpServletResponse;
        return this;
    }

    public ResponseDto setModel(Model model)
    {
        this.model = model;
        return this;
    }

    public ResponseDto setLoginForm(LoginForm loginForm)
    {
        this.loginForm = loginForm;
        return this;
    }


















    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public Model getModel() {
        return model;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }
}
