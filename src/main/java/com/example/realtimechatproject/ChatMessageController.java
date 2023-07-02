package com.example.realtimechatproject;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatMessageController {



    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage get(ChatMessage chatMessage)
    {
        return chatMessage;
    }

    @GetMapping("/chatPage")
    public String GetChatPage()
    {
        return "index.html";
    }

    @PostMapping("/form")
    public String GetFormPage()
    {
        System.out.println("xd");
        return "index.html";
    }

    @GetMapping("/start")
    public String GetMainPage()
    {
        return "login.html";
    }


}
