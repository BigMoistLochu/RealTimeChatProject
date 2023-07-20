package com.example.realtimechatproject.services;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.validationsForm.LoginFormValidator;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginPageService {


    private LoginFormValidator loginFormSecurity;

    public LoginPageService(LoginFormValidator loginFormSecurity)
    {
        this.loginFormSecurity = loginFormSecurity;
    }

    public String getValidForm(LoginForm form, Model model)
    {
        if(loginFormSecurity.checkForm(form))
            //po weryfikacji tego co przyszlo przechodzimy do sprawdzenia czy w bazie znajduje sie taki uzytkownik
            return "chat.html";
        else
        {
            String invalide = "Wrong Email or Password";
            model.addAttribute("invalid",invalide);
            model.addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }
    }
}
