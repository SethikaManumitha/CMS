package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class representing a user in the CMS system.
 * Uses Lombok annotations for boilerplate code reduction.
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NIC", length = 12, unique = true)
    private String nic;

    @Column(name = "FNAME", length = 50)
    private String firstName;

    @Column(name = "LNAME", length = 50)
    private String lastName;

    @Column(name = "EMAIL", length = 100, unique = true)
    private String email;

    @Column(name = "PASS", length = 100, nullable = false)
    private String password;

    @Column(name = "PHNO", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "ADDRESS", length = 255)
    private String address;

    @Column(name = "DOB", length = 255)
    private String dob;

    @Column(name = "GENDER", length = 255)
    private String gender;

    @Column(name = "ROLE", length = 255)
    private String role;

    @Column(name = "STATUS", length = 255)
    private String status;
}
