package com.example.realtimechatproject.controllers;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.services.controllersServices.LoginPageService;
import com.example.realtimechatproject.services.controllersServices.RegisterPageService;
import com.example.realtimechatproject.validationsForm.FormValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginPageController {

    private FormValidator formValidator;
    private LoginPageService loginPageService;

    private RegisterPageService registerPageService;






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
        return loginPageService.checkLoginForm(form,model);
    }

    @PostMapping("/register")
    public String GetValidRegisterFormPage(@ModelAttribute LoginForm form, Model model)
    {
        //to do zmiany
        return loginPageService.checkLoginForm(form,model);
    }




}
