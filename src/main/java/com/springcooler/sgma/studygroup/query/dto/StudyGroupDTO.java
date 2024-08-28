package com.springcooler.sgma.studygroup.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupDTO {
    private long groupId;
    private String groupName;
    private String activeStatus;
    private int groupMembers;
    private long userId;
    private int studyGroupCategoryId;
}