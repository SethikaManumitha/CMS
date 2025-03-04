package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

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
    private int id;

    @Column(name = "dept_name", length = 12, unique = true)
    private String deptName;

}
