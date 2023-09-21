package com.example.realtimechatproject.validations;
import com.example.realtimechatproject.models.IForm;
import org.springframework.stereotype.Component;


@Component
public class FormValidator <T extends IForm>{

    private T Form;


    public boolean validate(T form)
    {

        this.Form = form;
        String login = Form.getLogin();
        String haslo = Form.getHaslo();


        return checkLength(login, haslo)
                && checkEmail(login)
                && isBlank(login,haslo)
                && checkCorrectLetters(login,haslo);
    }


    private boolean checkLength(String login,String haslo)
    {
        return login.length() > 0
                && haslo.length() > 0
                && login.length() < 25
                && haslo.length() < 25;
    }

    private boolean checkEmail(String login)
    {
        return login.contains("@");
    }

    private boolean isBlank(String login,String haslo)
    {
        return !haslo.isBlank() && !login.isBlank();
    }

    private boolean checkCorrectLetters(String login, String haslo)
    {
        return !login.matches(".*[!#$%^&*()_+\\-=].*") && !haslo.matches(".*[!#$%^&*()_+\\-=].*");
    }






}
