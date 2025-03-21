package com.example.CMS.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private String title;
    private String dueTime;
    private String dueDate;
    private String type;
    private String description;
    private MultipartFile[] docUrl;
    private String status;
    private int classID;
    private int lecturerId;
}
