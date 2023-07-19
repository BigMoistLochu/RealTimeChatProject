package com.example.realtimechatproject.controllers;

import com.example.realtimechatproject.models.Form;
import com.example.realtimechatproject.validationsForm.LoginFormSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {

    LoginFormSecurity loginFormSecurity;
    LoginPageService loginPageService;

    @Autowired
    public LoginPageController(LoginFormSecurity loginFormSecurity,LoginPageService loginPageService)
    {
        this.loginFormSecurity = loginFormSecurity;
        this.loginPageService = loginPageService;
    }

    @GetMapping("/start")
    public String GetMainPage(Model model)
    {

        model.addAttribute("form", new Form());
        return "login.html";
    }

    @GetMapping("/chatView")
    public String GetChatPageController()
    {

        return "chat.html";
    }


    @PostMapping("/form")
    public String GetFormPage(@ModelAttribute Form form,Model model)
    {
        return loginPageService.getPageForm(form,model);
    }




}
