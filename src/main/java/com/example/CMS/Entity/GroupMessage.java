package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "group_messages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Student sender;  // Sender is a student

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "timestamp")
    private String timestamp;
}
