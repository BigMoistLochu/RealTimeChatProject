package com.example.realtimechatproject.validationsForm;

import com.example.realtimechatproject.models.LoginForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginFormSecurityTest {




    @Test
    void checkFormShouldReturnFalse() {
        //given
        FormValidator loginFormSecurityForcheckFormShouldReturnFalse = new FormValidator();
        LoginForm form = new LoginForm();
        form.setLogin("xd");
        form.setHaslo("ape");
        //then
        assertFalse(loginFormSecurityForcheckFormShouldReturnFalse.checkLoginForm(form));
    }
}