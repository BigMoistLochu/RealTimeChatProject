package com.example.realtimechatproject.controllers;

import com.example.realtimechatproject.models.Form;
import com.example.realtimechatproject.validationsForm.LoginPageSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {

    LoginPageSecurity loginPageSecurity;

    @Autowired
    public LoginPageController(LoginPageSecurity loginPageSecurity)
    {
        this.loginPageSecurity = loginPageSecurity;
    }

    @GetMapping("/start")
    public String GetMainPage(Model model)
    {

        model.addAttribute("form", new Form());
        return "login.html";
    }


    @PostMapping("/form")
    public String GetFormPage(@ModelAttribute Form form)
    {
        // tutaj bedzie Validowany
        if(loginPageSecurity.checkForm(form))

            //po weryfikacji tego co przyszlo przechodzimy do sprawdzenia czy w bazie znajduje sie taki uzytkownik


            return "index.html";
        else
        return "xddd";

    }



}
