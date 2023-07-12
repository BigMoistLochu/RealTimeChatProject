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

    @Autowired
    public LoginPageController(LoginFormSecurity loginFormSecurity)
    {
        this.loginFormSecurity = loginFormSecurity;
    }

    @GetMapping("/start")
    public String GetMainPage(Model model)
    {

        model.addAttribute("form", new Form());
        return "login.html";
    }


    @PostMapping("/form")
    public String GetFormPage(@ModelAttribute Form form,Model model)
    {
        // tutaj bedzie Validowany

        if(loginFormSecurity.checkForm(form))

            //po weryfikacji tego co przyszlo przechodzimy do sprawdzenia czy w bazie znajduje sie taki uzytkownik

            return "index.html";
        else
        {   String invalide = "invalids smth";
            model.addAttribute("invalid",invalide);
            return "login.html";
        }


    }




}
