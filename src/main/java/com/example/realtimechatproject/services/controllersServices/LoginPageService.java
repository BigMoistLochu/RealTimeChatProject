package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validationsForm.FormValidator;
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
            model.addAttribute("invalid","Wrong Email or Password");
            model.addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }

        //check user exist with this email(token)
        if(userService.isUserExists(form.getLogin()))
        {
            UserEntity user = userService.getUserByLogin(form.getLogin());
            System.out.println(user.getToken());
        }


        return "chat.html";
    }






}
