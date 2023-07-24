package com.example.realtimechatproject.validationsForm;


import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.RegisterForm;
import org.springframework.stereotype.Component;


@Component
public class FormValidator {

    private LoginForm form;

    private RegisterForm registerForm;


    public boolean checkLoginForm(LoginForm form)
    {

        this.form = form;

        return checkLength()
                && checkEmail()
                && isBlank()
                && checkCorrectLetter();
    }

    public boolean checkRegisterForm(RegisterForm registerForm)
    {

        this.registerForm = registerForm;

        return checkLength()
                && checkEmail()
                && isBlank()
                && checkCorrectLetter();
    }


    private boolean checkLength()
    {
        return form.getLogin().length() > 0
                && form.getHaslo().length() > 0
                && form.getLogin().length() < 25
                && form.getHaslo().length() < 25;
    }

    private boolean checkEmail()
    {
        return form.getLogin().contains("@");
    }

    private boolean isBlank()
    {
        return !form.getHaslo().isBlank() && !form.getLogin().isBlank();
    }

    private boolean checkCorrectLetter()
    {
        return !form.getLogin().matches(".*[!#$%^&*()_+\\-=].*") && !form.getHaslo().matches(".*[!#$%^&*()_+\\-=].*");
    }




}
