package com.example.realtimechatproject.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessage {

    private String value;

    private String user;

    private String userColor;

    public ChatMessage() {}

    public ChatMessage(String value) {
        this.value = value;
    }
}
