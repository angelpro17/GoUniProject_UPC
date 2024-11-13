package com.studentconnect.gouni.platform.chat.socket.interfaces.controller;

import com.studentconnect.gouni.platform.chat.socket.application.ChatService;
import com.studentconnect.gouni.platform.chat.socket.domain.ChatMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/chat")
@Tag(name = "Chat", description = "Controller for managing chat messages")
@CrossOrigin(origins = "https://frontend-five-wheat-92.vercel.app") // Permitir solicitudes desde Angular
public class ChatRestController {

    private final ChatService chatService;

    public ChatRestController(ChatService chatService) {
        this.chatService = chatService;
    }

    @Operation(summary = "Send a message")
    @ApiResponse(
            responseCode = "200",
            description = "Message sent successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ChatMessage.class)
            )
    )
    @PostMapping(
            value = "/send",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {
        return chatService.saveMessage("default-room", message);
    }

    @Operation(summary = "Get all messages")
    @ApiResponse(
            responseCode = "200",
            description = "Messages retrieved successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ChatMessage.class)
            )
    )
    @GetMapping(
            value = "/messages",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ChatMessage> getMessages() {
        return chatService.getOrCreateRoom("default-room").getMessages();
    }
}