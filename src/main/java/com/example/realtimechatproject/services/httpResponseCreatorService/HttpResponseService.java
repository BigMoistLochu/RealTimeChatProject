package com.example.realtimechatproject.services.httpResponseCreatorService;

import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.services.cookieService.CookieService;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.FormValidator;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HttpResponseService {
    private UserService userService;
    private FormValidator formValidator;

    private CookieService cookieService;

    private HttpResponseCreator response;

    @Autowired
    public HttpResponseService(UserService userService, FormValidator formValidator,CookieService cookieService) {
        this.userService = userService;
        this.formValidator = formValidator;
        this.cookieService = cookieService;
    }

    public HttpResponseCreator CordinatorOfEverything()
    {

        //SprawdzanieFormularza i nadawanie modelu
        response.getHttpServletResponse().setContentType(ValidateAForm());
        //nadawanie ciasta przy logowaniu:
        response.getHttpServletResponse().addCookie(getACookie());

        return response;
    }

    public HttpResponseService setTheHttpResponseFilter(HttpResponseCreator response)
    {
        this.response = response;
        return this;
    }

    private String ValidateAForm()
    {
        if(!formValidator.validate(response.getForm()))
        {
            response.getModel().addAttribute("infoForUser","Login or Password is valid");
            response.getModel().addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }


        if(!userService.isUserWithLoginAndHasloExists(response.getForm().getLogin(),response.getForm().getHaslo()))
        {
            response.getModel().addAttribute("infoForUser","This User dosnt exists");
            response.getModel().addAttribute("LoginForm", new LoginForm());
            return "login.html";
        }

        return"chat.html";
    }

    private Cookie getACookie()
    {
        return cookieService
                .injectCookieToUser(response
                        .getForm()
                        .getLogin());
    }


}
