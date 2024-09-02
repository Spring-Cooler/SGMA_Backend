package com.springcooler.sgma.studygroupcategory.command.application.controller;

import com.springcooler.sgma.studygroupcategory.command.application.dto.StudyGroupCategoryDTO;
import com.springcooler.sgma.studygroupcategory.command.application.service.AppStudyGroupCategoryService;
import com.springcooler.sgma.studygroupcategory.command.domain.aggregate.StudyGroupCategory;
import com.springcooler.sgma.studygroupcategory.common.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController("commandStudyGroupCategoryController")
@RequestMapping("/api/study-group/categories")
public class StudyGroupCategoryController {

    private final AppStudyGroupCategoryService studyGroupCategoryService;

    public StudyGroupCategoryController(AppStudyGroupCategoryService studyGroupCategoryService) {
        this.studyGroupCategoryService = studyGroupCategoryService;
    }

    // 스터디그룹 카테고리 생성
    @PostMapping("/")
    public ResponseDTO<?> registerStudyGroupCategory(@RequestBody StudyGroupCategoryDTO newCategory) {
        StudyGroupCategory category = studyGroupCategoryService.registStudyGroupCategory(newCategory);
        return ResponseDTO.ok(category);
    }

    // 스터디그룹 카테고리 삭제
    @DeleteMapping("/{categoryId}")
    public ResponseDTO<?> deleteStudyGroupCategory(@PathVariable Integer categoryId) {
        studyGroupCategoryService.deleteStudyGroupCategory(categoryId);
        return ResponseDTO.ok(null);
    }

}
