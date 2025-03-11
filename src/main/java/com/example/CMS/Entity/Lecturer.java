package com.example.CMS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lecturer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturerID")
    private int lecturerID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "specialisation", length = 100)
    private String specialisation;

    @Column(name = "highestQualification", length = 100)
    private String highestQualification;

    @JsonIgnore
    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Class> classes;
}
