package com.example.realtimechatproject.validationsForm;


import com.example.realtimechatproject.models.Form;
import org.springframework.stereotype.Component;


@Component
public class LoginFormSecurity {

    private Form form;


    public boolean checkForm(Form form)
    {
        this.form = form;

        if(checkLength()
                && checkEmail())
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




}
