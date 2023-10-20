package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.FormValidator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@AllArgsConstructor
public class LoginPageService {


    private FormValidator formValidator;

    private UserService userService;

    public String setViewAfterLoginForm(LoginForm form, Model model)
    {

        if(!formValidator.validate(form))
        {
            model.addAttribute("infoForUser","Login or Password is valid");
            model.addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }


        if(!userService.isUserWithLoginAndHasloExists(form.getLogin(),form.getHaslo()))
        {
            model.addAttribute("infoForUser","This User dosnt exists");
            model.addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }

        return"chat.html";
    }






}
