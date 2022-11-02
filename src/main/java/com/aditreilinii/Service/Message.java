package com.aditreilinii.Service;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    public Long getId() {
        return id;
    }

    @Id
    @SequenceGenerator(
            name = "messages_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "messages_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_sender_id")
    private User userSender = new User();
    @ManyToOne
    @JoinColumn(name = "user_reciever_id")
    private User userReciever;
    private String timestamp;

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    private MessageStatus status;

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReciever() {
        return userReciever;
    }

    public void setUserReciever(User userReciever) {
        this.userReciever = userReciever;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public Message(Long id, String message, User userSender, User userReciever, String timestamp, MessageStatus status) {
        this.id = id;
        this.message = message;
        this.userSender = userSender;
        this.userReciever = userReciever;
        this.timestamp = timestamp;
        this.status = status;
    }
    public Message() {
    }
}
