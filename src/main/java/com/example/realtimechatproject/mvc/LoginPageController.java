package com.example.realtimechatproject.mvc;

import com.example.realtimechatproject.services.cookieService.CookieService;
import com.example.realtimechatproject.services.httpResponseCreatorService.HttpResponseCreator;
import com.example.realtimechatproject.services.httpResponseCreatorService.HttpResponseService;
import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.RegisterForm;
import com.example.realtimechatproject.services.controllersServices.LoginPageService;
import com.example.realtimechatproject.services.controllersServices.RegisterPageService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class LoginPageController {


    private LoginPageService loginPageService;

    private RegisterPageService registerPageService;

    private HttpResponseService httpResponseService;

    private CookieService cookieService;




    @GetMapping("/")
    public String GetMainPage(Model model,HttpServletResponse response)
    {
        response.addCookie(new Cookie("Jan","Pawel"));
        model.addAttribute("LoginForm", new LoginForm());
        return "login.html";
    }

    @GetMapping("/register")
    public String GetRegisterPage(Model model)
    {
        model.addAttribute("RegisterForm", new RegisterForm());
        return "register.html";
    }

    @GetMapping("/talk")
    public String GetChatPage(@ModelAttribute LoginForm form,Model model,HttpServletRequest request,HttpServletResponse response)
    {
        Map<String,String> mapOfCookie = new HashMap<>();
        List<Cookie> cookieList = Arrays.stream(request.getCookies()).toList();
        cookieList.stream().forEach(cookie -> mapOfCookie.put(cookie.getName(),cookie.getValue()));
        cookieList.stream().forEach(cookie -> System.out.println(cookie.getName()+" wartosc: " + cookie.getValue()));
        if(mapOfCookie.containsKey("ID_SESSION"))
        {
            //wysylajac requesta sprawdzasz czy uzytkownik ma ciastko jesli nie to
            if(cookieService.checkCookie(request))
            {
                return "chat.html";
            }
        }


        model.addAttribute("infoForUser","Your Token Was Expired,try login again");
        model.addAttribute("LoginForm", new LoginForm());
        return "login.html";
    }


    @PostMapping("/")
    public String GetValidLoginFormPage(@ModelAttribute LoginForm form,Model model,HttpServletResponse response)
    {
       HttpResponseCreator responeFilter = HttpResponseCreator.CreateRespone()
               .setModel(model)
               .setForm(form)
               .setHttpServletResponse(response)
               .build();


       return httpResponseService.setTheHttpResponseFilter(responeFilter)
               .CordinatorOfEverything()
               .getHttpServletResponse().getContentType();
    }

    @PostMapping("/register")
    public String ValidRegisterFormPage(@ModelAttribute RegisterForm form, Model model) throws NoSuchAlgorithmException {

        return registerPageService.checkRegisterForm(form,model);
    }




}
