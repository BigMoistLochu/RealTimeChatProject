package com.example.realtimechatproject.controllers;


import com.example.realtimechatproject.models.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatMessageController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public ChatMessageController(SimpMessagingTemplate simpMessagingTemplate)
    {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

//    @DestinationVariable String id
    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
    public void get(ChatMessage chatMessage)
    {
        //to wysyla do brokera /topic/messages
        //w przyszlosci stworzymy /topic/id wiec w tubie bedzie wiecej socketow
//        System.out.println(id);
        simpMessagingTemplate.convertAndSend("/topic/messages",chatMessage);
//      return chatMessage;

    }



    @GetMapping("/chatPage")
    public String GetChatPage()
    {
        return "index.html";
    }




}
