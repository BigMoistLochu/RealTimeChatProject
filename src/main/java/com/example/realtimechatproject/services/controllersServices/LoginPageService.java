package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.validationsForm.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginPageService {


    private LoginFormValidator loginFormSecurity;

    @Autowired
    public LoginPageService(LoginFormValidator loginFormSecurity)
    {
        this.loginFormSecurity = loginFormSecurity;
    }

    public String checkLoginForm(LoginForm form, Model model)
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
