package com.kafka.Consumer.service;

import com.kafka.Consumer.model.ReceivedMessage;
import com.kafka.Consumer.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{


    private final MessageRepository repository;

    public MessageServiceImpl(MessageRepository repository){
        this.repository = repository;
    }

    @Override
    public void saveMessage(ReceivedMessage message) {

        repository.save(message);
    }

    @Override
    public List<ReceivedMessage> findAllMessages() {

        List<ReceivedMessage> messages = new ArrayList();
        repository.findAll().forEach(message -> messages.add(message));

        return messages;
    }
}
