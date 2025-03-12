package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DepartmentLecturerDTO {
    private int departmentId;
    private String departmentName;
    private List<LecturerDTO> lecturers;
}
