package com.example.CMS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Resource")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resourceID")
    private int resourceID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "status")
    private int status;


}
