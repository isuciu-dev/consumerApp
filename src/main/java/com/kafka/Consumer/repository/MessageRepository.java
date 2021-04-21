package com.kafka.Consumer.repository;

import com.kafka.Consumer.model.ReceivedMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<ReceivedMessage, Long> {
}
