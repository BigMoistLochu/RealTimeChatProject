package com.example.realtimechatproject.NewFiczer;


import com.example.realtimechatproject.models.LoginForm;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

public class HttpResponseFilter {

    private HttpServletResponse httpServletResponse;

    private Model model;
    private LoginForm loginForm;

    private HttpResponseFilter(){}

    public static HttpResponseFilter CreateRespone()
    {
        return new HttpResponseFilter();
    }

    public HttpResponseFilter build()
    {
        return this;
    }
    public HttpResponseFilter setHttpServletResponse(HttpServletResponse httpServletResponse)
    {
        this.httpServletResponse = httpServletResponse;
        return this;
    }

    public HttpResponseFilter setModel(Model model)
    {
        this.model = model;
        return this;
    }

    public HttpResponseFilter setLoginForm(LoginForm loginForm)
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
