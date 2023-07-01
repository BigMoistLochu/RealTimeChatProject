package com.example.realtimechatproject;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {



    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage get(ChatMessage chatMessage)
    {
        return chatMessage;
    }

    //mozemy zrobic tak ze w pokoju gdzie chcemy gadac np z Konradem kazdy sie podpina(ale to wtedy
    //kazdy kto ma otwarty chat widzi to co ktos inny pisze, dlatego musi zostac utworzony
    //pokoj w momencie kiedy otwieramy czat i tylko 2 osoby sa w nim
    //czyli


}
