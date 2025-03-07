package com.example.CMS.Entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturerID", nullable = false )
    private Lecturer lecturer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminID", nullable = true )
    private Admin admin;

    @Column(name = "day", length = 100)
    private String day;

    @Column(name = "startTime", length = 100)
    private String startTime;

    @Column(name = "endTime", length = 100)
    private String endTime;

    @Column(name = "maxStudents")
    private int maxStudents;

    @Column(name = "status", length = 100)
    private String status;



}
