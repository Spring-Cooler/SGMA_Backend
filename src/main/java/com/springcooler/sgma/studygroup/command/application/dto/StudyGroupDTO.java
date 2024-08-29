package com.springcooler.sgma.studygroup.command.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupDTO {
    private Long groupId;
    private String groupName;
    private String activeStatus;
    private int groupMembers;
    private long userId;
    private int studyGroupCategoryId;
}
