package com.example.realtimechatproject.services.controllersServices;

import com.example.realtimechatproject.models.RegisterForm;
import com.example.realtimechatproject.validationsForm.FormValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@AllArgsConstructor
public class RegisterPageService {


    private FormValidator formValidator;


    public boolean checkRegisterForm(RegisterForm form, Model model)
    {

        if(formValidator.checkRegisterForm(form)){
            return false;
        }

        return true;
    }


}
