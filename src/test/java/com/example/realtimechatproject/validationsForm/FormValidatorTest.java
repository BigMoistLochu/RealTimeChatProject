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

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfLoginIsBlank() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("");
        registerForm.setHaslo("randompassword");

        assertFalse(formValidator.checkRegisterForm(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfPasswordIsBlank() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("randomLogin");
        registerForm.setHaslo("");

        assertFalse(formValidator.checkRegisterForm(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfPasswordIsToLong() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("MoreThan25CharacterIsIncorrect");
        registerForm.setHaslo("NormalPass");

        assertFalse(formValidator.checkRegisterForm(registerForm));
    }


}