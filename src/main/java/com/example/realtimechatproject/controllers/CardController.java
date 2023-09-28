package com.example.realtimechatproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CardController {

    @GetMapping("/test")
    public String getCardWeb()
    {
        return "newChat.html";
    }



}
