package com.springcooler.sgma.studygroupcategory.command.application.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupCategoryDTO {
    private int categoryId;
    private String categoryName;
}
