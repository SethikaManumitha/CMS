package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "class_attendance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClassAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class clazz;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private String date;
}
