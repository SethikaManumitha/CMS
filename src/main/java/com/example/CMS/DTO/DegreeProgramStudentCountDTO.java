package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DegreeProgramStudentCountDTO {
    private String programName;
    private Long studentCount;
}