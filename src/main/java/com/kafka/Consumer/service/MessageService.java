package com.kafka.Consumer.service;

import com.kafka.Consumer.model.ReceivedMessage;

import java.util.List;

public interface MessageService {

    public void saveMessage(ReceivedMessage message);
    public List<ReceivedMessage> findAllMessages();
}
