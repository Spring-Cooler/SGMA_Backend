package com.springcooler.sgma.studygroupcategory.query.service;

import com.springcooler.sgma.studygroupcategory.query.dto.StudyGroupCategoryDTO;
import com.springcooler.sgma.studygroupcategory.query.repository.StudyGroupCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupCategoryServiceImpl implements StudyGroupCategoryService {

    private final StudyGroupCategoryMapper studyGroupCategoryMapper;

    @Autowired
    public StudyGroupCategoryServiceImpl(StudyGroupCategoryMapper studyGroupCategoryMapper) {
        this.studyGroupCategoryMapper = studyGroupCategoryMapper;
    }

    // 스터디그룹 카테고리 전체 조회
    @Override
    public List<StudyGroupCategoryDTO> findAllStudyGroupCategories() {
        return studyGroupCategoryMapper.findAllStudyGroupCategories();
    }

    // 스터디그룹 카테고리 단건 조회(카테고리 아이디)
    @Override
    public List<StudyGroupCategoryDTO> findStudyGroupCategoryByCategoryId(int categoryId) {
        return studyGroupCategoryMapper.findStudyGroupCategoryByCategoryId(categoryId);
    }

}
