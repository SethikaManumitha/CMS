package com.example.CMS.Entity;


import jakarta.persistence.*;
import lombok.*;


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

    @Column(name = "date", length = 100)
    private String date;

    @Column(name = "startTime", length = 100)
    private String startTime;

    @Column(name = "endTime", length = 100)
    private String endTime;

    @Column(name = "eventType", length = 100)
    private String eventType;

    @Column(name = "organizer", length = 100)
    private String organizer;

    @Column(name = "MaxCapacity")
    private int maxCapacity; // Changed to camel case

    @Column(name = "RegisterDeadline", length = 100)
    private String registerDeadline; // Changed to camel case

    @Column(name = "status", length = 100)
    private String status;



}
