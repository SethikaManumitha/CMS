package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "support_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupportMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", columnDefinition = "TEXT", nullable = false)
    private String title;

    @Column(name = "sender_type", nullable = false) // "student", "lecturer", or "admin"
    private String senderType;

    @Column(name = "sender_id", nullable = false)
    private int senderId;

    @Column(name = "receiver_type", nullable = false) // always "admin" for user messages, or "student"/"lecturer" for replies
    private String receiverType;

    @Column(name = "message", columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(name = "category", columnDefinition = "TEXT", nullable = false)
    private String category;

    @Column(name = "file_path", columnDefinition = "TEXT", nullable = false)
    private String filePath;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}
