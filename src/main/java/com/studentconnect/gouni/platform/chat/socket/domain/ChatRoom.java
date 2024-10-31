package com.studentconnect.gouni.platform.chat.socket.domain;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String id;
    private List<ChatMessage> messages;

    // Constructor sin argumentos requerido
    public ChatRoom() {
        this.messages = new ArrayList<>();
    }

    // Constructor con id
    public ChatRoom(String id) {
        this.id = id;
        this.messages = new ArrayList<>();
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}