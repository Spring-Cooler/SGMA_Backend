package com.springcooler.sgma.studygroup.command.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="STUDY_GROUP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroup {

    @Id
    @Column(name="GROUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("group_id")
    private Long groupId;

    @Column(name="GROUP_NAME")
    @JsonProperty("group_name")
    private String groupName;

    @Enumerated(EnumType.STRING)
    @Column(name="ACTIVE_STATUS")
    @JsonProperty("active_status")
    private StudyGroupStatus activeStatus;

    @Column(name="GROUP_MEMBERS")
    @JsonProperty("group_members")
    private Integer groupMembers;

    @Column(name="USER_ID")
    @JsonProperty("user_id")
    private Long userId;

    @Column(name="STUDY_GROUP_CATEGORY_ID")
    @JsonProperty("category_id")
    private Integer studyGroupCategoryId;

}
