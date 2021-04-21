package com.kafka.Consumer.controller;

import com.kafka.Consumer.model.ReceivedMessage;
import com.kafka.Consumer.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public Long saveMessage(@RequestBody ReceivedMessage message){

        messageService.saveMessage(message);
        return message.getId();
    }

    @GetMapping("/messages")
    public List<ReceivedMessage> getMessages(){

        System.out.println("==============NUMBER OF MESSAGEIS IS: " + messageService.findAllMessages().size());
        return messageService.findAllMessages();
    }
}
