package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartmentResourceDTO {
    private int deptId;
    private String deptName;
    private int resourceId;
    private int capacity;
    private String description;
    private String resourceName;
    private int status;
    private String type;
}
