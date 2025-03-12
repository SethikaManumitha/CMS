package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String dob;
    private String gender;
    private String role;
    private String status;
    private int lecturerID;
    private String designation;
    private String specialisation;
    private String highestQualification;

    public LecturerDTO(int id, String firstName, String lastName, String email, String phoneNumber, String address, String dob, String gender, String role, String status, int lecturerID, String designation, String specialisation, String highestQualification) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.role = role;
        this.status = status;
        this.lecturerID = lecturerID;
        this.designation = designation;
        this.specialisation = specialisation;
        this.highestQualification = highestQualification;
    }
}
