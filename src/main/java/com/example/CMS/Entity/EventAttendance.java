package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "event_attendance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "time", nullable = false)
    private String time;
}
