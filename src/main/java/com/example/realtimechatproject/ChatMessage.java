package com.example.realtimechatproject;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessage {

    private String value;

    private String user;

    public ChatMessage() {}

    public ChatMessage(String value) {
        this.value = value;
    }
}
