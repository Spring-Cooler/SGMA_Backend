package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroup.command.domain.repository.StudyGroupRepository;
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
    public void modifyStudyGroup(StudyGroupDTO modifyStudyGroup) {

    }

    // 스터디 그룹 삭제
    @Transactional
    public void deleteStudyGroup(long groupId) {

    }
}
