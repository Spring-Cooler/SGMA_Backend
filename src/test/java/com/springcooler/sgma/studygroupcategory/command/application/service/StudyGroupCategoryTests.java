package com.springcooler.sgma.studygroupcategory.command.application.service;

import com.springcooler.sgma.studygroupcategory.command.application.dto.StudyGroupCategoryDTO;
import com.springcooler.sgma.studygroupcategory.command.domain.aggregate.StudyGroupCategory;
import com.springcooler.sgma.studygroupcategory.common.exception.CommonException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class StudyGroupCategoryTests {

    @Autowired
    private AppStudyGroupCategoryService studyGroupCategoryService;

    @DisplayName("스터디그룹 카테고리 생성 테스트")
    @Test
    void testRegistStudyGroupCategory() {
        //Given
        StudyGroupCategoryDTO newCategory = new StudyGroupCategoryDTO();
        newCategory.setCategoryName("보컬");

        //When
        StudyGroupCategory category = studyGroupCategoryService.registStudyGroupCategory(newCategory);
        if(category != null) {
            System.out.println(category);
        }

        //Then
        Assertions.assertNotNull(category);
    }

    @DisplayName("스터디그룹 카테고리 삭제 테스트")
    @Test
    void testDeleteStudyGroupCategory() {
        //Given
        int categoryId = 1;

        //When
        studyGroupCategoryService.deleteStudyGroupCategory(categoryId);
        System.out.println("DELETE SUCCESS");

        //Then
        Assertions.assertThrows(CommonException.class,
                () -> studyGroupCategoryService.deleteStudyGroupCategory(categoryId)
        );
    }
}
