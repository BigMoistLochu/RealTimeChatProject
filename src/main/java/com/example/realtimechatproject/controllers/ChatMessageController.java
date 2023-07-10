package com.example.realtimechatproject.controllers;


import com.example.realtimechatproject.ChatMessage;
import com.example.realtimechatproject.models.Form;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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




}
