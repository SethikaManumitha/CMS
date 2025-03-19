package com.example.CMS.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassAttendanceDTO {
    private int classId;
    private int userId;
    private String status;
}
