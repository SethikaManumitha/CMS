package com.example.CMS.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "StudentCourse")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentCourseID")
    private int studentCourseID;

    @ManyToOne
    @JoinColumn(name = "studentID", nullable = false)
    @JsonIgnore
    private Student students;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

    @Column(name="marks")
    private int marks;
    @Column(name="status")
    private String status;
}
