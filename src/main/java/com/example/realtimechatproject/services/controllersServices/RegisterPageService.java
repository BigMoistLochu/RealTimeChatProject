package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.validationsForm.RegisterFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RegisterPageService {


    RegisterFormValidator registerFormValidator;

    @Autowired
    public RegisterPageService(RegisterFormValidator registerFormValidator) {
        this.registerFormValidator = registerFormValidator;
    }

    public boolean getValidForm(LoginForm form, Model model)
    {

        if(registerFormValidator.checkRegisterForm(form)){
            return false;
        }

        return true;
    }


}
