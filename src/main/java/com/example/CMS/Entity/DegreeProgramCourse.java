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



    @Column(name = "ProgramID",  nullable = false)
    private int ProgramID;


    @Column(name = "CourseID")
    private int CourseID;

    @Column(name = "semester")
    private int semester;

    @Column(name = "year")
    private int year;
}
