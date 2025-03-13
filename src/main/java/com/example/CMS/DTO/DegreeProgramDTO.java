package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DegreeProgramDTO {
    private int programID;
    private String programName;
    private String description;
    private String level;
    private String degreeType;
    private int duration;
    private String entryRequirement;
    private int maxStudents;
    private String status;
    private List<CourseDTO> courses;
}
