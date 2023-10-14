package com.example.realtimechatproject.mvc;

import com.example.realtimechatproject.NewFiczer.HttpResponseFilter;
import com.example.realtimechatproject.NewFiczer.HttpResponseService;
import com.example.realtimechatproject.models.LoginForm;
import com.example.realtimechatproject.models.RegisterForm;
import com.example.realtimechatproject.services.controllersServices.LoginPageService;
import com.example.realtimechatproject.services.controllersServices.RegisterPageService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.NoSuchAlgorithmException;

@Controller
@AllArgsConstructor
public class LoginPageController {


    private LoginPageService loginPageService;

    private RegisterPageService registerPageService;

    private HttpResponseService httpResponseService;




    @GetMapping("/")
    public String GetMainPage(Model model)
    {
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
    public String GetChatPage()
    {
        return "chat.html";
    }


    @PostMapping("/")
    public String GetValidLoginFormPage(@ModelAttribute LoginForm form,Model model,HttpServletResponse response)
    {
       HttpResponseFilter responeFilter = HttpResponseFilter.CreateRespone()
               .setModel(model)
               .setLoginForm(form)
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
