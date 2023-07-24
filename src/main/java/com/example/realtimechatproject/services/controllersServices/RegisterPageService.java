package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.validationsForm.RegisterFormValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@AllArgsConstructor
public class RegisterPageService {


    RegisterFormValidator registerFormValidator;



    public boolean checkRegisterForm(LoginForm form, Model model)
    {

        if(registerFormValidator.checkForm(form)){
            return false;
        }

        return true;
    }


}
