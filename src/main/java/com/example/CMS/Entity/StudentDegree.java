package com.example.CMS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "StudentDegree")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentDegreeID")
    private int studentDegreeID;
    @ManyToOne
    @JoinColumn(name = "studentID", nullable = false)
    private Student student;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "programID", nullable = false)
    private DegreeProgram degreeProgram;

    @Column(name="enrollmentYear")
    private int enrollmentYear;

    @Column(name="status", length = 30)
    private String status;

    @Column(name="grade", length = 30)
    private String grade;


}
