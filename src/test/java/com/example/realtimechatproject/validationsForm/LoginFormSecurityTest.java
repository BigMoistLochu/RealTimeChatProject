package com.example.realtimechatproject.validationsForm;

import com.example.realtimechatproject.models.LoginForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginFormSecurityTest {




    @Test
    void checkFormShouldReturnFalse() {
        //given
        LoginFormValidator loginFormSecurityForcheckFormShouldReturnFalse = new LoginFormValidator();
        LoginForm form = new LoginForm();
        form.setLogin("xd");
        form.setHaslo("ape");
        //then
        assertFalse(loginFormSecurityForcheckFormShouldReturnFalse.checkForm(form));
    }
}