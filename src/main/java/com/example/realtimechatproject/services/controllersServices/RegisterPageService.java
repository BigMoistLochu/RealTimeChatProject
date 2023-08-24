package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.RegisterForm;
import com.example.realtimechatproject.validationsForm.FormValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@AllArgsConstructor
public class RegisterPageService {


    private FormValidator formValidator;


    public String checkRegisterForm(RegisterForm form, Model model)
    {

        if(formValidator.checkRegisterForm(form))
        {
            //po weryfikacji tego co przyszlo przechodzimy do sprawdzenia czy w bazie znajduje sie taki uzytkownik
            model.addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }
        else
        {

            model.addAttribute("invalid","Wrong Email or Password");
            model.addAttribute("RegisterForm", new RegisterForm());
            return "register.html";
        }

    }


}
