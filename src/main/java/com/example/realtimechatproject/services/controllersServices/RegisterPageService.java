package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.RegisterForm;
import com.example.realtimechatproject.models.User;
import com.example.realtimechatproject.services.hashingService.TokenManagerService;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.FormValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class RegisterPageService {


    private FormValidator formValidator;

    private UserService userService;






    public String checkRegisterForm(RegisterForm form, Model model) throws NoSuchAlgorithmException {
        //tutaj validuje czy dane ktore przychodza z formularza sa git
        if(!formValidator.validate(form))
        {
            model.addAttribute("infoForUser","Wrong Email or Password");
            model.addAttribute("RegisterForm", new RegisterForm());
            return "register.html";
        }

        //tutaj sprawdza czy uzytkownik istnieje juz w bazie danych
        if(userService.isUserExists(form.getLogin()))
        {
            model.addAttribute("infoForUser","User already exist with this email");
            model.addAttribute("RegisterForm", new RegisterForm());
            return "register.html";
        }

        //wiemy ze formularz jest git,wiemy ze user nie istnieje wiec pozostaje nam zahashowac haslo


        userService.addUser(User.builder()
                .Login(form.getLogin())
                .Haslo(form.getHaslo())
                .Name(form.getName())
                .Surname(form.getSurname())
                .build());

        //zwroc login jesli wszystko jest git
        model.addAttribute("infoForUser","You Are Registered");
        model.addAttribute("LoginForm", new LoginForm());
        return "login.html";
    }


}
