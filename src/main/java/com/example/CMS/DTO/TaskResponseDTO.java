package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {

    private String title;
    private String dueTime;
    private String dueDate;
    private String type;
    private String description;
    private String docUrl;
    private String status;
    private int classID;
    private int lecturerId;
}
