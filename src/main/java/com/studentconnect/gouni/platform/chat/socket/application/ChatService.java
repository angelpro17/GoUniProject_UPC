package com.studentconnect.gouni.platform.chat.socket.application;

import com.studentconnect.gouni.platform.chat.socket.domain.ChatMessage;
import com.studentconnect.gouni.platform.chat.socket.domain.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ChatService {
    private final Map<String, ChatRoom> chatRooms = new HashMap<>();

    public ChatRoom getOrCreateRoom(String roomId) {
        return chatRooms.computeIfAbsent(roomId, id -> new ChatRoom(id));
    }

    public Optional<ChatRoom> getRoomById(String roomId) {
        return Optional.ofNullable(chatRooms.get(roomId));
    }

    public ChatMessage processMessage(ChatMessage message) {
        return new ChatMessage(message.getMessage(), message.getUser());
    }

    public ChatMessage saveMessage(String roomId, ChatMessage message) {
        ChatRoom room = getOrCreateRoom(roomId);
        room.addMessage(message);
        return message;
    }
}
