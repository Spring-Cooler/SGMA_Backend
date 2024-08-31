package com.springcooler.sgma.studygroup.command.domain.aggregate;

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
    private long groupId;

    @Column(name="GROUP_NAME")
    private String groupName;

    @Column(name="ACTIVE_STATUS")
    private String activeStatus;

    @Column(name="GROUP_MEMBERS")
    private int groupMembers;

    @Column(name="USER_ID")
    private long userId;

    @Column(name="STUDY_GROUP_CATEGORY_ID")
    private int studyGroupCategoryId;

}
