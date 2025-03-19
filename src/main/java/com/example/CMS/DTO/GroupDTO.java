package com.example.CMS.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupDTO {

    private String groupName;
    private String description;
    private List<Integer> memberIds;
}
