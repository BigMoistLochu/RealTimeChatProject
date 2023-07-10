package com.example.realtimechatproject.controllers;

import com.example.realtimechatproject.models.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {


    @GetMapping("/start")
    public String GetMainPage(Model model)
    {
        //wrzucamy do login.html klase odpowiedzialna za formularz
        model.addAttribute("form", new Form());
        return "login.html";
    }
    @PostMapping("/form")
    public String GetFormPage(@ModelAttribute Form form)
    {
        // tutaj bedzie Validowany
        System.out.println(form.getHaslo());
        System.out.println(form.getLogin());

        return "index.html";
    }



}
