package com.example.CMS.DTO;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private String title;
    private String date;
    private String dueDate;
    private String description;
    private String docUrl;
    private String status;
    private int courseId;
    private int lecturerId;
}
