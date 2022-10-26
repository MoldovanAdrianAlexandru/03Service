package com.aditreilinii.Service;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
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
//    private User userReciver; ???

    private enum status{
        SENT,
        DELIVERED,
        SEEN,
        DELETED
    }
}
