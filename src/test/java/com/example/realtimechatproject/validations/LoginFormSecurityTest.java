package com.example.realtimechatproject.validations;

import com.example.realtimechatproject.models.LoginForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginFormSecurityTest {




    @Test
    void checkLoginFormValidatorShouldReturnFalseWhenDataIsIncorrect() {
        //given
        FormValidator loginFormSecurityForcheckFormShouldReturnFalse = new FormValidator();
        LoginForm form = new LoginForm();
        form.setLogin("xd");
        form.setHaslo("ape");
        //then
        assertFalse(loginFormSecurityForcheckFormShouldReturnFalse.validate(form));
    }

    @Test
    void checkLoginFormShouldReturnTrueWhenDataIsCorrect() {
        //given
        FormValidator loginFormSecurityForcheckFormShouldReturnFalse = new FormValidator();
        LoginForm form = new LoginForm();
        form.setLogin("xd@wp.pl");
        form.setHaslo("ape");
        //then
        assertTrue(loginFormSecurityForcheckFormShouldReturnFalse.validate(form));
    }

    @Test
    void checkLoginFormShouldReturnFalseWhenDataIsInCorrect() {
        //given
        FormValidator loginFormSecurityForcheckFormShouldReturnFalse = new FormValidator();
        LoginForm form = new LoginForm();
        form.setLogin("xd@wp.pl");
        form.setHaslo("");
        //then
        assertFalse(loginFormSecurityForcheckFormShouldReturnFalse.validate(form));
    }
}