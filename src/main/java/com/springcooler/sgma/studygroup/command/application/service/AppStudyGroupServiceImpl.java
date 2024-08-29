package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroupStatus;
import com.springcooler.sgma.studygroup.command.domain.repository.StudyGroupRepository;
import com.springcooler.sgma.studygroup.command.domain.service.DomainStudyGroupService;
import com.springcooler.sgma.studygroup.command.infrastructure.service.InfraStudyGroupService;
import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppStudyGroupServiceImpl implements AppStudyGroupService {

    private final ModelMapper modelMapper;
    private final DomainStudyGroupService domainStudyGroupService;
    private final InfraStudyGroupService infraStudyGroupService;
    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public AppStudyGroupServiceImpl(ModelMapper modelMapper,
                                    DomainStudyGroupService domainStudyGroupService,
                                    InfraStudyGroupService infraStudyGroupService,
                                    StudyGroupRepository studyGroupRepository) {
        this.modelMapper = modelMapper;
        this.domainStudyGroupService = domainStudyGroupService;
        this.infraStudyGroupService = infraStudyGroupService;
        this.studyGroupRepository = studyGroupRepository;
    }

    // 스터디 그룹 생성
    @Transactional
    @Override
    public StudyGroup registStudyGroup(StudyGroupDTO newStudyGroup) {
        // 스터디 그룹 생성 코드
        newStudyGroup.setActiveStatus(StudyGroupStatus.ACTIVE.name());
        StudyGroup studyGroup =
                studyGroupRepository.save(modelMapper.map(newStudyGroup, StudyGroup.class));

        // 스터디 그룹장 추가 요청 코드
        StudyGroupMemberDTO owner = new StudyGroupMemberDTO();
        owner.setUserId(studyGroup.getUserId());
        owner.setGroupId(studyGroup.getGroupId());
        infraStudyGroupService.registStudyGroupOwner(owner);

        // 스터디 그룹원 수 1명으로 초기화
        studyGroup.setGroupMembers(1);
        studyGroupRepository.save(studyGroup);

        return studyGroup;
    }

    // 스터디 그룹 정보 수정
    @Transactional
    @Override
    public StudyGroup modifyStudyGroup(StudyGroupDTO modifyStudyGroup) {
        // 기존 엔티티 조회
        StudyGroup existingStudyGroup = studyGroupRepository.findById(modifyStudyGroup.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("잘못된 수정 요청입니다."));

        modifyStudyGroup.setActiveStatus(StudyGroupStatus.ACTIVE.name());

        // DTO를 엔티티에 매핑
        modelMapper.map(modifyStudyGroup, existingStudyGroup);

        // 엔티티 저장
        return studyGroupRepository.save(existingStudyGroup);
    }

    // 스터디 그룹 삭제
    @Transactional
    @Override
    public void deleteStudyGroup(long groupId) {
        StudyGroup deleteStudyGroup = studyGroupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 삭제 요청입니다."));

        // 스터디 그룹 삭제 유효성 검사
        if(!domainStudyGroupService.isActive(deleteStudyGroup.getActiveStatus()))
            throw new EntityNotFoundException("잘못된 삭제 요청입니다.");

        // INACTIVE 처리
        deleteStudyGroup.setActiveStatus(StudyGroupStatus.INACTIVE.name());
        studyGroupRepository.save(deleteStudyGroup);
    }
}
