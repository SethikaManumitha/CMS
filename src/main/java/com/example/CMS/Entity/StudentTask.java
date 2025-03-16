package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_task_id")
    private int studentTaskId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "grade")
    private String grade;

    @Column(name = "status", nullable = false)
    private String status;
}
