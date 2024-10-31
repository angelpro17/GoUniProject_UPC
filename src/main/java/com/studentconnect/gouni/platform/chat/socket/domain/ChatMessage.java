package com.studentconnect.gouni.platform.chat.socket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatMessage {
    private String message;
    private String user;
}