package com.springcooler.sgma.studygroupmember.command.application.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;
import com.springcooler.sgma.studygroupmember.command.domain.repository.StudyGroupMemberRepository;
import com.springcooler.sgma.studygroupmember.command.domain.service.DomainStudyGroupMemberService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class AppStudyGroupMemberService {

    private final ModelMapper modelMapper;
    private final DomainStudyGroupMemberService domainStudyGroupMemberService;
    private final StudyGroupMemberRepository studyGroupMemberRepository;

    @Autowired
    public AppStudyGroupMemberService(ModelMapper modelMapper,
                                      DomainStudyGroupMemberService domainStudyGroupMemberService,
                                      StudyGroupMemberRepository studyGroupMemberRepository) {
        this.modelMapper = modelMapper;
        this.domainStudyGroupMemberService = domainStudyGroupMemberService;
        this.studyGroupMemberRepository = studyGroupMemberRepository;
    }

    // 스터디 그룹원 추가
    @Transactional
    public StudyGroupMember registStudyGroupMember(StudyGroupMemberDTO newMember) {
        newMember.setMemberEnrolledAt(new Timestamp(System.currentTimeMillis()));
        newMember.setMemberStatus("ACTIVE");
        return studyGroupMemberRepository.save(modelMapper.map(newMember, StudyGroupMember.class));
    }

    // 스터디 그룹원 정보 수정
    @Transactional
    public StudyGroupMember modifyStudyGroupMember(StudyGroupMemberDTO modifyMember) {
        // 기존 엔티티 조회
        StudyGroupMember existingMember = studyGroupMemberRepository.findById(modifyMember.getMemberId())
                .orElseThrow(() -> new EntityNotFoundException("잘못된 수정 요청입니다."));

        // DTO를 엔티티에 매핑
        modelMapper.map(modifyMember, existingMember);

        // 엔티티 저장
        return studyGroupMemberRepository.save(existingMember);
    }

    // 스터디 그룹원 삭제
    @Transactional
    public void deleteStudyGroupMember(long memberId) {
        // 기존 엔티티 조회
        StudyGroupMember deleteMember = studyGroupMemberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 삭제 요청입니다."));

        // 유효성 검사
        if (!domainStudyGroupMemberService.isActive(deleteMember.getMemberStatus()))
            throw new EntityNotFoundException("잘못된 삭제 요청입니다.");

        deleteMember.setMemberWithdrawnAt(new Timestamp(System.currentTimeMillis()));
        deleteMember.setMemberStatus("INACTIVE");
        studyGroupMemberRepository.save(deleteMember);
    }
}
