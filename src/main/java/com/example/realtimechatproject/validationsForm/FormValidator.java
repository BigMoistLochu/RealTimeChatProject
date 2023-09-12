package com.example.realtimechatproject.validationsForm;


import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.RegisterForm;
import org.springframework.stereotype.Component;


@Component
public class FormValidator {

    private LoginForm loginForm;

    private RegisterForm registerForm;


    public boolean checkLoginForm(LoginForm form)
    {

        this.loginForm = form;
        String login = loginForm.getLogin();
        String haslo = loginForm.getHaslo();


        return checkLength(login, haslo)
                && checkEmail(login)
                && isBlank(login,haslo)
                && checkCorrectLetters(login,haslo);
    }

    public boolean checkRegisterForm(RegisterForm form)
    {

        this.registerForm = form;
        String login = registerForm.getLogin();
        String haslo = registerForm.getHaslo();


        return checkLength(login, haslo)
                && checkEmail(login)
                && isBlank(login,haslo)
                && checkCorrectLetters(login,haslo);
    }


    private boolean checkLength(String login,String haslo)
    {
        return login.length() > 0
                && haslo.length() > 0
                && login.length() < 25
                && haslo.length() < 25;
    }

    private boolean checkEmail(String login)
    {
        return login.contains("@");
    }

    private boolean isBlank(String login,String haslo)
    {
        return !haslo.isBlank() && !login.isBlank();
    }

    private boolean checkCorrectLetters(String login, String haslo)
    {
        return !login.matches(".*[!#$%^&*()_+\\-=].*") && !haslo.matches(".*[!#$%^&*()_+\\-=].*");
    }






}
