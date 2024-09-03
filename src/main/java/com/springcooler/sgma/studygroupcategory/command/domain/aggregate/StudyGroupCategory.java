package com.springcooler.sgma.studygroupcategory.command.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="STUDY_GROUP_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupCategory {

    @Id
    @Column(name="STUDY_GROUP_CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("category_id")
    private long categoryId;

    @Column(name="STUDY_GROUP_CATEGORY_NAME")
    @JsonProperty("category_name")
    private String categoryName;

}
