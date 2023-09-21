package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.User;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.FormValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@AllArgsConstructor
public class LoginPageService {


    private FormValidator formValidator;

    private UserService userService;



    public String checkLoginForm(LoginForm form, Model model)
    {

        if(!formValidator.validate(form))
        {
            model.addAttribute("infoForUser","Wrong Email or Password");
            model.addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }

        //check user exist with this email(token)
        if(userService.isUserExists(form.getLogin()))
        {
            User user = userService.getUserByLogin(form.getLogin());
            System.out.println(user.getToken());
        }


        return "chat.html";
    }






}
