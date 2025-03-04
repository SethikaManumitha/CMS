package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int adminId;

    // One admin can be one user
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // One admin can have one department
    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;
}
