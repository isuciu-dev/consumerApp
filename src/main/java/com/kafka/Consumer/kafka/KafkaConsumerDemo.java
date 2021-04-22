package com.kafka.Consumer.kafka;

import com.kafka.Consumer.model.ReceivedMessage;
import com.kafka.Consumer.service.MessageService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class KafkaConsumerDemo {

    private final MessageService messageService;

    public KafkaConsumerDemo(MessageService messageService){
        this.messageService = messageService;
    }

    Properties props = new Properties();

    Object o1 = props.put("bootstrap.servers", "localhost:9092");
    Object o2 = props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    Object o3 = props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    Object o4 = props.put("group.id", "test");
    Object o5 = props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");



    public void fetchMessages(){

        KafkaConsumer myConsumer = new KafkaConsumer(props);

        List<TopicPartition> topicPartitions = new ArrayList();
        TopicPartition partition = new TopicPartition("personsTopic", 0);
        topicPartitions.add(partition);
        myConsumer.assign(topicPartitions);

        try{
            int i = 1;
            while(i>0){

                i--;
                Duration duration = Duration.ofMillis(0);
                Duration duration2 = Duration.ofMillis(10000);
                myConsumer.poll(duration);
                myConsumer.seekToBeginning(topicPartitions);
                ConsumerRecords<String, String> records = myConsumer.poll(duration2);
                for(ConsumerRecord<String, String> record : records){

                    ReceivedMessage message = new ReceivedMessage();
                    message.setMessage(record.value());
                    System.out.println("********************** " + record.value());
                    messageService.saveMessage(message);
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            myConsumer.close();
        }
    }
}
