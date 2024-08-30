package com.springcooler.sgma.studygroupcategory.query.controller;

import com.springcooler.sgma.studygroupcategory.query.common.ResponseMessage;
import com.springcooler.sgma.studygroupcategory.query.service.StudyGroupCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController("queryStudyGroupCategoryController")
@RequestMapping("/api/study-group/categories")
public class StudyGroupCategoryController {

    private final StudyGroupCategoryService studyGroupCategoryService;

    @Autowired
    public StudyGroupCategoryController(StudyGroupCategoryService studyGroupCategoryService) {
        this.studyGroupCategoryService = studyGroupCategoryService;
    }

    // 스터디그룹 카테고리 전체 조회
    @GetMapping("/")
    public ResponseEntity<ResponseMessage> findAllStudyGroupCategories() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupCategoryService.findAllStudyGroupCategories()
                .stream()
                .collect(
                        Collectors.toMap(
                                studyGroupCategory -> String.valueOf(studyGroupCategory.getCategoryId()),
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // 스터디그룹 카테고리 단건 조회(카테고리 아이디)
    @GetMapping("/{categoryId}")
    public ResponseEntity<ResponseMessage> findStudyGroupNoticeByNoticeId(@PathVariable int categoryId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json"
                , StandardCharsets.UTF_8));

        Map<String, Object> responseMap = studyGroupCategoryService.findStudyGroupCategoryByCategoryId(categoryId)
                .stream()
                .collect(
                        Collectors.toMap(
                                studyGroupCategory -> String.valueOf(studyGroupCategory.getCategoryId()),
                                Function.identity()
                        )
                );

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
