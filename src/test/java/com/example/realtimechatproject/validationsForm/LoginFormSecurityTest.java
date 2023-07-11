package com.example.realtimechatproject.validationsForm;

import com.example.realtimechatproject.models.Form;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginFormSecurityTest {




    @Test
    void checkFormShouldReturnFalse() {
        //given
        LoginFormSecurity loginFormSecurityForcheckFormShouldReturnFalse = new LoginFormSecurity();
        Form form = new Form();
        form.setLogin("xd");
        form.setHaslo("ape");
        //then
        assertFalse(loginFormSecurityForcheckFormShouldReturnFalse.checkForm(form));
    }
}