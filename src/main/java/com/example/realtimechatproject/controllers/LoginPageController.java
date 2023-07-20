package com.example.realtimechatproject.controllers;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.services.controllersServices.LoginPageService;
import com.example.realtimechatproject.validationsForm.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {

    LoginFormValidator loginFormValidator;
    LoginPageService loginPageService;

    @Autowired
    public LoginPageController(LoginFormValidator loginFormValidator, LoginPageService loginPageService)
    {
        this.loginFormValidator = loginFormValidator;
        this.loginPageService = loginPageService;
    }




    @GetMapping("/")
    public String GetMainPage(Model model)
    {
        model.addAttribute("LoginForm", new LoginForm());
        return "login.html";
    }

    @GetMapping("/register")
    public String GetRegisterPage(Model model)
    {
        model.addAttribute("LoginForm", new LoginForm());
        return "register.html";
    }

    @GetMapping("/talk")
    public String GetChatPage()
    {
        return "chat.html";
    }


    @PostMapping("/")
    public String GetValidLoginFormPage(@ModelAttribute LoginForm form, Model model)
    {
        return loginPageService.getValidForm(form,model);
    }

    @PostMapping("/register")
    public String GetValidRegisterFormPage(@ModelAttribute LoginForm form, Model model)
    {
        //to do zmiany
        return loginPageService.getValidForm(form,model);
    }




}
