package com.example.realtimechatproject.NewFiczer;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.FormValidator;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HttpResponseService {
    private UserService userService;
    private FormValidator formValidator;

    private CookieService cookieService;

    private HttpResponseFilter response;

    @Autowired
    public HttpResponseService(UserService userService, FormValidator formValidator,CookieService cookieService) {
        this.userService = userService;
        this.formValidator = formValidator;
        this.cookieService = cookieService;
    }

    public HttpResponseFilter CordinatorOfEverything()
    {

        //SprawdzanieFormularza i nadawanie modelu
        response.getHttpServletResponse().setContentType(ValidateAForm());
        //nadawanie ciasta przy logowaniu:
        response.getHttpServletResponse().addCookie(getACookie());
        return response;
    }

    public HttpResponseService setTheHttpResponseFilter(HttpResponseFilter response)
    {
        this.response = response;
        return this;
    }

    private String ValidateAForm()
    {
        if(!formValidator.validate(response.getLoginForm()))
        {
            response.getModel().addAttribute("infoForUser","Login or Password is valid");
            response.getModel().addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }


        if(!userService.isUserExists(response.getLoginForm().getLogin()))
        {
            response.getModel().addAttribute("infoForUser","This User dosnt exists");
            response.getModel().addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }

        return"chat.html";
    }

    private Cookie getACookie()
    {
        return cookieService.getCookie(response.getLoginForm().getLogin());
    }


}
