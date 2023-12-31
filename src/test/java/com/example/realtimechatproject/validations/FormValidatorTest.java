package com.example.realtimechatproject.validations;

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

        assertFalse(formValidator.validate(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnTrueIfEmailIsCorrect() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("474@wp.pl");
        registerForm.setHaslo("randompassword");

        assertTrue(formValidator.validate(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfLoginIsBlank() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("");
        registerForm.setHaslo("randompassword");

        assertFalse(formValidator.validate(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfPasswordIsBlank() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("randomLogin");
        registerForm.setHaslo("");

        assertFalse(formValidator.validate(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfPasswordIsToLong() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("NormalLogin");
        registerForm.setHaslo("MoreThan25CharacterIsIncorrect");

        assertFalse(formValidator.validate(registerForm));
    }

    @Test
    void checkRegisterFormMethodShouldReturnFalseIfLoginIsToLong() {

        RegisterForm registerForm = new RegisterForm();
        registerForm.setLogin("MoreThan25CharacterIsIncorrect");
        registerForm.setHaslo("NormalPass");

        assertFalse(formValidator.validate(registerForm));
    }


}