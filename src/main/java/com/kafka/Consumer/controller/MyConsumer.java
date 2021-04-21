package com.kafka.Consumer.controller;


import com.kafka.Consumer.kafka.KafkaConsumerDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/startListening")
public class MyConsumer {

    private final KafkaConsumerDemo consumer;

    public MyConsumer(KafkaConsumerDemo consumer){
        this.consumer = consumer;
    }

    @GetMapping
    public String startListening(){

        consumer.fetchMessages();
        return "received all messages";
    }
}
