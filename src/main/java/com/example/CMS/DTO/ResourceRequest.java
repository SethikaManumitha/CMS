package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceRequest {
    private int userID;
    private int departmentID;
    private String name;
    private String type;
    private String description;
    private int capacity;
    private int status;
}
