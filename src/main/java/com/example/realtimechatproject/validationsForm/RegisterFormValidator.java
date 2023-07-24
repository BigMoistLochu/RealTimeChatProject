package com.example.realtimechatproject.validationsForm;

import com.example.realtimechatproject.models.LoginForm;
import org.springframework.stereotype.Component;

@Component
public class RegisterFormValidator {

    private LoginForm form;

    public boolean checkForm(LoginForm form)
    {
        this.form= form;

        return true;
    }



}
