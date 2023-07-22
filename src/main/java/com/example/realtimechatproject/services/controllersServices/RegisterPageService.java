package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;

public class RegisterPageService {

    private LoginForm form;

    public boolean checkForm(LoginForm form)
    {
        this.form = form;

        return true;
    }


}
