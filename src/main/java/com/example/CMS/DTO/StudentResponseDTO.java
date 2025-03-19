package com.example.CMS.DTO;


import com.example.CMS.Entity.StudentCourse;
import com.example.CMS.Entity.StudentDegree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDTO {
    private int studentID;
    private String firstName;
    private String lastName;
    private String email;
    private List<DegreeProgramDTO> studentDegrees;
    private List<CourseDTO> studentCourses;
}
