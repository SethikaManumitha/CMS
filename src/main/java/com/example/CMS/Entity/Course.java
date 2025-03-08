package com.example.CMS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Entity class representing a course in the CMS system.
 * Uses Lombok annotations for boilerplate code reduction.
 */
@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private int courseID;

    @Column(name = "Course_name", length = 200,unique = true)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "lecturerID", nullable = false)
    @JsonIgnoreProperties("courses")
    private Lecturer lecturer;

    @Column(name = "credits")
    private int credits;

    @Column(name = "status", length = 20)
    private String status;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties("courses")
    private List<DegreeProgram> degreePrograms;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentCourse> studentCourse;
}
