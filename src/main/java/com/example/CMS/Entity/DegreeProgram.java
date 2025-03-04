package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Entity class representing a degree Program in the CMS system.
 * Uses Lombok annotations for boilerplate code reduction.
 */
@Entity
@Table(name = "degree_program")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DegreeProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProgramID")
    private int ProgramID;

    // Foreign key reference to Department
    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    @Column(name = "program_name", length = 200,unique = true)
    private String program_name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "duration")
    private int duration;

    @Column(name = "level", length = 30)
    private String level;

    @Column(name = "degree_type", length = 10)
    private String degree_type;

    @Column(name = "entry_requirement", length = 500)
    private String entry_requirement;

    @Column(name = "max_students")
    private int max_students;

    @Column(name = "status", length = 15)
    private String status;



}
