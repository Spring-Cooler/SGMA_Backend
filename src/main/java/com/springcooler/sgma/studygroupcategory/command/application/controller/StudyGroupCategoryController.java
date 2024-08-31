package com.springcooler.sgma.studygroupcategory.command.application.controller;

import com.springcooler.sgma.studygroupcategory.command.application.dto.StudyGroupCategoryDTO;
import com.springcooler.sgma.studygroupcategory.command.application.service.AppStudyGroupCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController("commandStudyGroupCategoryController")
@RequestMapping("/api/study-group/categories")
public class StudyGroupCategoryController {

    private final AppStudyGroupCategoryService studyGroupCategoryService;

    public StudyGroupCategoryController(AppStudyGroupCategoryService studyGroupCategoryService) {
        this.studyGroupCategoryService = studyGroupCategoryService;
    }

    // 스터디그룹 카테고리 생성
    @PostMapping("/")
    public ResponseEntity<?> registerStudyGroupCategory(@RequestBody StudyGroupCategoryDTO newCategory) {
        return ResponseEntity
                .created(URI.create("/api/study-group/categories/"
                        + studyGroupCategoryService.registStudyGroupCategory(newCategory).getCategoryId()))
                .build();
    }

    // 스터디그룹 카테고리 삭제
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteStudyGroupCategory(@PathVariable int categoryId) {
        studyGroupCategoryService.deleteStudyGroupCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

}
