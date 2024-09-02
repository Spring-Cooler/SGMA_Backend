package com.springcooler.sgma.studygroupmember.command.application.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.GroupRole;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.RestStatus;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMemberStatus;
import com.springcooler.sgma.studygroupmember.command.domain.repository.StudyGroupMemberRepository;
import com.springcooler.sgma.studygroupmember.command.domain.service.DomainStudyGroupMemberService;
import com.springcooler.sgma.studygroupmember.common.exception.CommonException;
import com.springcooler.sgma.studygroupmember.common.exception.ErrorCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class AppStudyGroupMemberServiceImpl implements AppStudyGroupMemberService {

    private final ModelMapper modelMapper;
    private final DomainStudyGroupMemberService domainStudyGroupMemberService;
    private final StudyGroupMemberRepository studyGroupMemberRepository;

    @Autowired
    public AppStudyGroupMemberServiceImpl(ModelMapper modelMapper,
                                          DomainStudyGroupMemberService domainStudyGroupMemberService,
                                          StudyGroupMemberRepository studyGroupMemberRepository) {
        this.modelMapper = modelMapper;
        this.domainStudyGroupMemberService = domainStudyGroupMemberService;
        this.studyGroupMemberRepository = studyGroupMemberRepository;
    }

    // 스터디 그룹장 추가
    @Transactional
    @Override
    public StudyGroupMember registStudyGroupOwner(StudyGroupMemberDTO owner) {
        // DTO 유효성 검사
        if(!domainStudyGroupMemberService.isValidDTO(RestStatus.POST, owner))
            throw new CommonException(ErrorCode.INVALID_REQUEST_BODY);

        // ACTIVE 처리
        owner.setMemberEnrolledAt(LocalDateTime.now().withNano(0));
        owner.setMemberStatus(StudyGroupMemberStatus.ACTIVE);
        owner.setGroupRole(GroupRole.ROLE_OWNER);

        return studyGroupMemberRepository.save(modelMapper.map(owner, StudyGroupMember.class));
    }

    // 스터디 그룹원 추가
    @Transactional
    @Override
    public StudyGroupMember registStudyGroupMember(StudyGroupMemberDTO newMember) {
        // DTO 유효성 검사
        if(!domainStudyGroupMemberService.isValidDTO(RestStatus.POST, newMember))
            throw new CommonException(ErrorCode.INVALID_REQUEST_BODY);

        // ACTIVE 처리
        newMember.setMemberEnrolledAt(LocalDateTime.now().withNano(0));
        newMember.setMemberStatus(StudyGroupMemberStatus.ACTIVE);
        newMember.setGroupRole(GroupRole.ROLE_MEMBER);

        return studyGroupMemberRepository.save(modelMapper.map(newMember, StudyGroupMember.class));
    }

    // 스터디 그룹원 정보 수정
    @Transactional
    @Override
    public StudyGroupMember modifyStudyGroupMember(StudyGroupMemberDTO modifyMember) {
        // DTO 유효성 검사
        if(!domainStudyGroupMemberService.isValidDTO(RestStatus.PUT, modifyMember))
            throw new CommonException(ErrorCode.INVALID_REQUEST_BODY);

        // 기존 엔티티 조회
        StudyGroupMember existingMember = studyGroupMemberRepository.findById(modifyMember.getMemberId())
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_MEMBER));

        // DTO를 엔티티에 매핑
        modelMapper.map(modifyMember, existingMember);

        // 엔티티 저장
        return studyGroupMemberRepository.save(existingMember);
    }

    // 스터디 그룹원 삭제
    @Transactional
    @Override
    public void deleteStudyGroupMember(Long memberId) {
        // 기존 엔티티 조회
        StudyGroupMember deleteMember = studyGroupMemberRepository.findById(memberId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_MEMBER));

        // 유효성 검사
        if (!domainStudyGroupMemberService.isActive(deleteMember.getMemberStatus()))
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_MEMBER);

        // INACTIVE 처리
        deleteMember.setMemberWithdrawnAt(LocalDateTime.now().withNano(0));
        deleteMember.setMemberStatus(StudyGroupMemberStatus.INACTIVE);
        studyGroupMemberRepository.save(deleteMember);
    }

}
