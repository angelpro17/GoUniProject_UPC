package com.studentconnect.gouni.platform.chat.socket.interfaces.dto;


import lombok.Data;

@Data
public class ChatMessageRequest {
    private String message;
    private String user;
}
