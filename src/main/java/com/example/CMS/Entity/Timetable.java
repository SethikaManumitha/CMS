package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "time_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timetable_id")
    private int timetableId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", nullable = false)
    private Class classEntity;

    @Column(name = "day_of_week", nullable = false, length = 20)
    private String dayOfWeek;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "status", length = 20)
    private String status;
}
