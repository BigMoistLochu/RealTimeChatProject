package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.validationsForm.FormValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@AllArgsConstructor
public class LoginPageService {


    private FormValidator formValidator;



    public String checkLoginForm(LoginForm form, Model model)
    {

        if(!formValidator.checkLoginForm(form))
        {
            model.addAttribute("invalid","Wrong Email or Password");
            model.addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }

        return "chat.html";
    }






}
