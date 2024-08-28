package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroup.command.domain.repository.StudyGroupRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("studyGroupApplicationService")
public class StudyGroupService {

    private final ModelMapper modelMapper;
    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public StudyGroupService(ModelMapper modelMapper, StudyGroupRepository studyGroupRepository) {
        this.modelMapper = modelMapper;
        this.studyGroupRepository = studyGroupRepository;
    }

    // 스터디 그룹 생성
    @Transactional
    public StudyGroup registStudyGroup(StudyGroupDTO newStudyGroup) {
        return studyGroupRepository.save(modelMapper.map(newStudyGroup, StudyGroup.class));
    }

    // 스터디 그룹 정보 수정
    @Transactional
    public StudyGroup modifyStudyGroup(StudyGroupDTO modifyStudyGroup) {
        // 기존 엔티티 조회
        StudyGroup existingStudyGroup = studyGroupRepository.findById(modifyStudyGroup.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("잘못된 수정 요청입니다."));

        // DTO를 엔티티에 매핑
        modelMapper.map(modifyStudyGroup, existingStudyGroup);

        // 엔티티 저장
        return studyGroupRepository.save(existingStudyGroup);
    }

    // 스터디 그룹 삭제
    @Transactional
    public void deleteStudyGroup(long groupId) {
        studyGroupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 삭제 요청입니다."));
        studyGroupRepository.deleteById(groupId);
    }
}
