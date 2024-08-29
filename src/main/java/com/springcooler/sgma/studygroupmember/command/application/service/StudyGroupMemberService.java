package com.springcooler.sgma.studygroupmember.command.application.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;
import com.springcooler.sgma.studygroupmember.command.domain.repository.StudyGroupMemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service("studyGroupMemberApplicationService")
public class StudyGroupMemberService {

    private final ModelMapper modelMapper;
    private final StudyGroupMemberRepository studyGroupMemberRepository;

    @Autowired
    public StudyGroupMemberService(ModelMapper modelMapper, StudyGroupMemberRepository studyGroupMemberRepository) {
        this.modelMapper = modelMapper;
        this.studyGroupMemberRepository = studyGroupMemberRepository;
    }

    // 스터디 그룹원 추가
    @Transactional
    public StudyGroupMember registStudyGroupMember(StudyGroupMemberDTO newMember) {

        // 현재 시간 가져오기
        LocalDateTime now = LocalDateTime.now();

        // 밀리초 이하 값을 제거 (초 단위로만 남김)
        LocalDateTime truncatedNow = now.withNano(0);

        // LocalDateTime을 Timestamp로 변환
        Timestamp timestamp = Timestamp.valueOf(truncatedNow);

        newMember.setMemberEnrolledAt(timestamp);
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
        StudyGroupMember deleteMember = studyGroupMemberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("잘못된 삭제 요청입니다."));

        // 현재 시간 가져오기
        LocalDateTime now = LocalDateTime.now();

        // 밀리초 이하 값을 제거 (초 단위로만 남김)
        LocalDateTime truncatedNow = now.withNano(0);

        // LocalDateTime을 Timestamp로 변환
        Timestamp timestamp = Timestamp.valueOf(truncatedNow);

        deleteMember.setMemberWithdrawnAt(timestamp);
        deleteMember.setMemberStatus("INACTIVE");
        studyGroupMemberRepository.save(deleteMember);
    }
}
