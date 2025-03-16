package com.example.CMS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classID")
    private int classID;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "lecturerID", nullable = false)
    private Lecturer lecturer;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "startTime", nullable = false)
    private LocalTime startTime;

    @Column(name = "endTime", nullable = false)
    private LocalTime endTime;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "status", length = 100)
    private String status;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ClassAttendance> attendanceList;
}
