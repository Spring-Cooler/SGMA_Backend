package com.springcooler.sgma.studygroupapplicant.command.application.service;


import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.StudyGroupApplicantId;
import com.springcooler.sgma.studygroup.command.application.service.AppStudyGroupService;
import com.springcooler.sgma.studygroupapplicant.command.application.dto.StudyGroupApplicantCommandDTO;
import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.ApplicationStatus;
import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.StudyGroupApplicant;
import com.springcooler.sgma.studygroupapplicant.command.domain.repository.StudyGroupApplicantRepository;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudyGroupApplicantCommandServiceImpl implements StudyGroupApplicantCommandService{

    private final StudyGroupApplicantRepository studyGroupApplicantRepository;
    private final ModelMapper modelMapper;
    private final AppStudyGroupService appStudyGroupService;

    @Autowired
    public StudyGroupApplicantCommandServiceImpl(StudyGroupApplicantRepository studyGroupApplicantRepository,AppStudyGroupService appStudyGroupService, ModelMapper modelMapper) {
        this.studyGroupApplicantRepository = studyGroupApplicantRepository;
        this.modelMapper = modelMapper;
        this.appStudyGroupService =appStudyGroupService;
    }


    @Override
    public StudyGroupApplicant applyStudyGroup(StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO) {
        StudyGroupApplicant studyGroupApplicant = StudyGroupApplicant.builder()
                .userId(studyGroupApplicantCommandDTO.getUserId())
                .applicationStatus(ApplicationStatus.WAIT)
                .recruitmentBoardId(studyGroupApplicantCommandDTO.getRecruitmentBoardId())
                .build();
        studyGroupApplicantRepository.save(studyGroupApplicant);

        return studyGroupApplicant;
    }

    @Override
    public void cancelStudyGroupApply(long userId, long recruitmentBoardId) {
        StudyGroupApplicantId studyGroupApplicantId = new StudyGroupApplicantId(userId, recruitmentBoardId);
        if (!studyGroupApplicantRepository.existsById(studyGroupApplicantId)) {
            throw new EntityNotFoundException("신청자를 찾을 수 없습니다.");
        }
        studyGroupApplicantRepository.deleteById(studyGroupApplicantId);
    }



    @Override
    public void approveStudyGroupApplicant(long userId, long groupId) {
        StudyGroupApplicantId studyGroupApplicantId = new StudyGroupApplicantId(userId, groupId);

        // 복합 키를 사용해 엔티티 검색
        StudyGroupApplicant studyGroupApplicant = studyGroupApplicantRepository.findById(studyGroupApplicantId)
                .orElseThrow(() -> new EntityNotFoundException("신청자를 찾을 수 없습니다."));

        // 상태 업데이트
        studyGroupApplicant.setApplicationStatus(ApplicationStatus.ACCEPT);
        studyGroupApplicantRepository.save(studyGroupApplicant);

        // DTO 생성 및 서비스 호출
        StudyGroupMemberDTO studyGroupMemberDTO = new StudyGroupMemberDTO();
        studyGroupMemberDTO.setUserId(userId);
        studyGroupMemberDTO.setGroupId(groupId);

        appStudyGroupService.registAcceptedMember(studyGroupMemberDTO);
    }
}
