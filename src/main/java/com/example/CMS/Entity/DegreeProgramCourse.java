package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Join table representing the relationship between Degree Programs and Courses.
 * Includes additional attributes: semester and year.
 */
@Entity
@Table(name = "degree_program_course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DegreeProgramCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false) // Foreign key to DegreeProgram
    private DegreeProgram degreeProgram;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false) // Foreign key to Course
    private Course course;

    @Column(name = "semester")
    private int semester;

    @Column(name = "year")
    private int year;
}
