package com.example.realtimechatproject.validationsForm;


import com.example.realtimechatproject.models.LoginForm;
import org.springframework.stereotype.Component;


@Component
public class LoginFormValidator {

    private LoginForm form;


    public boolean checkForm(LoginForm form)
    {
        this.form = form;

        if(checkLength()
                && checkEmail()
                && isBlank()
                && checkCorrectLetter()
        )
            return true;
        else
            return false;
    }


    private boolean checkLength()
    {
        if(form.getLogin().length()>0
                && form.getHaslo().length()>0
                && form.getLogin().length()<25
                && form.getHaslo().length()<25)
                return true;
        else return false;

    }

    private boolean checkEmail()
    {
        if(!form.getLogin().contains("@"))
            return false;
        return true;
    }

    private boolean isBlank()
    {
        if(form.getHaslo().isBlank() || form.getLogin().isBlank())
            return false;
        return true;
    }

    private boolean checkCorrectLetter()
    {
        if(form.getLogin().matches(".*[!#$%^&*()_+\\-=].*") || form.getHaslo().matches(".*[!#$%^&*()_+\\-=].*"))
            return false;
        return true;


    }




}
