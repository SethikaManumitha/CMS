package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "due_date", nullable = false)
    private String dueDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "doc_url")
    private String docUrl;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;
}
