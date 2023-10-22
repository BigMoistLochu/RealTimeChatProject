package com.example.realtimechatproject.NewFiczer;


import com.example.realtimechatproject.models.IForm;
import com.example.realtimechatproject.models.LoginForm;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;


public class HttpResponseCreator {

    private HttpServletResponse httpServletResponse;

    private Model model;
    private IForm form;

    private HttpResponseCreator(){}

    public static HttpResponseCreator CreateRespone()
    {
        return new HttpResponseCreator();
    }

    public HttpResponseCreator build()
    {
        return this;
    }
    public HttpResponseCreator setHttpServletResponse(HttpServletResponse httpServletResponse)
    {
        this.httpServletResponse = httpServletResponse;
        return this;
    }

    public HttpResponseCreator setModel(Model model)
    {
        this.model = model;
        return this;
    }

    public HttpResponseCreator setForm(LoginForm loginForm)
    {
        this.form = loginForm;
        return this;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public Model getModel() {
        return model;
    }

    public IForm getForm() {
        return form;
    }
}
