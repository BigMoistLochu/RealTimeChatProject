package com.example.realtimechatproject.controllers;

import com.example.realtimechatproject.models.Form;
import com.example.realtimechatproject.validationsForm.LoginFormSecurity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginPageService {


    LoginFormSecurity loginFormSecurity;

    public LoginPageService(LoginFormSecurity loginFormSecurity)
    {
        this.loginFormSecurity = loginFormSecurity;
    }

    public String getPageForm(Form form, Model model)
    {
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
