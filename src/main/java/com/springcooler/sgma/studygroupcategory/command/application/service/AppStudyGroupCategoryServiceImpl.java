package com.springcooler.sgma.studygroupcategory.command.application.service;

import com.springcooler.sgma.studygroupcategory.command.application.dto.StudyGroupCategoryDTO;
import com.springcooler.sgma.studygroupcategory.command.domain.aggregate.StudyGroupCategory;
import com.springcooler.sgma.studygroupcategory.command.domain.repository.StudyGroupCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppStudyGroupCategoryServiceImpl implements AppStudyGroupCategoryService {

    private final ModelMapper modelMapper;
    private final StudyGroupCategoryRepository studyGroupCategoryRepository;

    @Autowired
    public AppStudyGroupCategoryServiceImpl(ModelMapper modelMapper,
                                            StudyGroupCategoryRepository studyGroupCategoryRepository) {
        this.modelMapper = modelMapper;
        this.studyGroupCategoryRepository = studyGroupCategoryRepository;
    }

    // 스터디그룹 카테고리 생성
    @Transactional
    @Override
    public StudyGroupCategory registStudyGroupCategory(StudyGroupCategoryDTO newCategory) {
        return studyGroupCategoryRepository.save(modelMapper.map(newCategory, StudyGroupCategory.class));
    }

    // 스터디그룹 카테고리 삭제
    @Transactional
    @Override
    public void deleteStudyGroupCategory(int categoryId) {
        // 기존 엔티티 조회
        StudyGroupCategory deleteCategory =
                studyGroupCategoryRepository.findById(categoryId).orElseThrow(
                        () -> new EntityNotFoundException("잘못된 삭제 요청입니다."));

        studyGroupCategoryRepository.delete(deleteCategory);
    }

}
