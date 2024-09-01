package com.springcooler.sgma.studygroup.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudyGroupDTO {

    @JsonProperty("group_id")
    private Long groupId;

    @JsonProperty("group_name")
    private String groupName;

    @JsonProperty("active_status")
    private String activeStatus;

    @JsonProperty("group_members")
    private Integer groupMembers;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("category_id")
    private Integer studyGroupCategoryId;

}
