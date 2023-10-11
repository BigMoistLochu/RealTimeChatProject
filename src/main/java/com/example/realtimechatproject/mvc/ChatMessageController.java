package com.example.realtimechatproject.mvc;
import com.example.realtimechatproject.models.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public ChatMessageController(SimpMessagingTemplate simpMessagingTemplate)
    {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    //@DestinationVariable("id") String id, paramentr<<<
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage get(ChatMessage chatMessage)
    {
        //to wysyla do brokera /topic/messages
        //w przyszlosci stworzymy /topic/id wiec w tubie bedzie wiecej socketow
//        System.out.println(id);
//        simpMessagingTemplate.convertAndSend("/topic/messages",chatMessage);
      return chatMessage;
    }



}
