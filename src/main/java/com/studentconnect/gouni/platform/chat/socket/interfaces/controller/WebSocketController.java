package com.studentconnect.gouni.platform.chat.socket.interfaces.controller;


import com.studentconnect.gouni.platform.chat.socket.application.ChatService;
import com.studentconnect.gouni.platform.chat.socket.domain.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {


    private final ChatService chatService;

    public WebSocketController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message) {
        return chatService.saveMessage(roomId, message);
    }
}
