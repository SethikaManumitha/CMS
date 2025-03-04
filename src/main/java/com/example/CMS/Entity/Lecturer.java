package com.example.CMS.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecturer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private int lecturerId;


    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "specialization", length = 255)
    private String specialization;

    @Column(name = "highest_qualification", length = 255)
    private String highestQualification;

}
