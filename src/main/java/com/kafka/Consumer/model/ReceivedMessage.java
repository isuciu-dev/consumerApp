package com.kafka.Consumer.model;

import javax.persistence.*;

@Entity(name = "RECEIVEDMESSAGE")
@Table
public class ReceivedMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MESSAGE")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
