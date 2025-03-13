package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "announcement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private int announcementId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "closing_date", nullable = false)
    private String closingDate;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    // Many-to-One relationship with Admin
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;
}
