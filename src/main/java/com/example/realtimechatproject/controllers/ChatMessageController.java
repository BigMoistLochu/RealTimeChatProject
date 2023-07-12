package com.example.realtimechatproject.controllers;


import com.example.realtimechatproject.ChatMessage;
import com.example.realtimechatproject.models.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatMessageController {

    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public ChatMessageController(SimpMessagingTemplate simpMessagingTemplate)
    {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    //@DestinationVariable String canalId
    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
    public void get(ChatMessage chatMessage)
    {
        simpMessagingTemplate.convertAndSend("/topic/messages",chatMessage);
//        return chatMessage;
    }

    @GetMapping("/chatPage")
    public String GetChatPage()
    {
        return "index.html";
    }




}
