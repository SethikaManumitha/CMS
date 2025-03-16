package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventID")
    private int eventID;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    @Column(name = "eventType", length = 100)
    private String eventType;

    @Column(name = "organizer", length = 100)
    private String organizer;

    @Column(name = "MaxCapacity")
    private int maxCapacity;

    @Column(name = "RegisterDeadline")
    private LocalDate registerDeadline;

    @Column(name = "status", length = 100)
    private String status;
}
