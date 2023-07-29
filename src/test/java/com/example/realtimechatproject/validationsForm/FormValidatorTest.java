package com.example.realtimechatproject.validationsForm;

import com.example.realtimechatproject.models.RegisterForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormValidatorTest {

    FormValidator formValidator = new FormValidator();

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfEmailIsWrong() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("474!");
        registerForm.setHaslo("randompassword");

        assertFalse(formValidator.checkRegisterForm(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnTrueIfEmailIsCorrect() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("474@wp.pl");
        registerForm.setHaslo("randompassword");

        assertTrue(formValidator.checkRegisterForm(registerForm));
    }
}