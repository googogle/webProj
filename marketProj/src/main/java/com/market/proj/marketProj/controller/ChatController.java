package com.market.proj.marketProj.controller;

import com.market.proj.marketProj.Service.ChatService;
import com.market.proj.marketProj.Service.TransactionService;
import com.market.proj.marketProj.dto.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    private final TransactionService transactionService;

    @PostMapping
    public ChatRoom createRoom(@RequestBody String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }

    @GetMapping(value = "/getRoomId")
    public String getRoomId(@RequestParam Long productIdx) {
        return transactionService.findByProductIdx(productIdx).getChatRoomId();
    }
}