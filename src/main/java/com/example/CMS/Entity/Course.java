package com.example.CMS.Entity;

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
    private int CourseID;

    @Column(name = "Course_name", length = 200,unique = true)
    private String Course_name;

    @Column(name = "credits")
    private int credits;

    @Column(name = "status", length = 20)
    private String status;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<DegreeProgramCourse> degreePrograms; // Relationship with Degree Programs

}
