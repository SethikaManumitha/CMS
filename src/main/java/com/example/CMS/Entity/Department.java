package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Entity class representing a Department in the CMS system.
 * Uses Lombok annotations for boilerplate code reduction.
 */
@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "dept_name", length =30, unique = true)
    private String deptName;

    // One department can have multiple degree programs
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DegreeProgram> degreePrograms;

}
