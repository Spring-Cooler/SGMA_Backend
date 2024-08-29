package com.springcooler.sgma.studygroupmember.command.application.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;
import com.springcooler.sgma.studygroupmember.command.domain.repository.StudyGroupMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Transactional
class StudyGroupMemberServiceTests {

    @Autowired
    private StudyGroupMemberService studyGroupMemberService;

    @Autowired
    private StudyGroupMemberRepository studyGroupMemberRepository;

    @DisplayName("스터디 그룹원 추가 테스트")
    @Test
    void testSaveStudyGroupMember() {
        //Given
        StudyGroupMemberDTO newMember = new StudyGroupMemberDTO();
        newMember.setUserId(1);
        newMember.setGroupId(5);

        //When
        StudyGroupMember member = studyGroupMemberService.registStudyGroupMember(newMember);
        if (member != null) {
            System.out.println(member);
        }

        //Then
        Assertions.assertNotNull(member);
    }

    @DisplayName("스터디 그룹원 정보 수정 테스트")
    @Test
    void testModifyStudyGroupMember() {
        //Given
        String dateTimeString = "2023-09-07 21:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        StudyGroupMemberDTO modifyMember = new StudyGroupMemberDTO();
        modifyMember.setMemberId(21);
        modifyMember.setMemberEnrolledAt(timestamp);
        modifyMember.setMemberWithdrawnAt(new Timestamp(System.currentTimeMillis()));
        modifyMember.setMemberStatus("INACTIVE");
        modifyMember.setUserId(5);
        modifyMember.setGroupId(5);

        //When
        StudyGroupMember member = studyGroupMemberService.modifyStudyGroupMember(modifyMember);
        if (member != null) {
            System.out.println(member);
        }

        //Then
        Assertions.assertNotNull(member);
    }

    @DisplayName("스터디 그룹원 삭제 테스트")
    @Test
    void testDeleteStudyGroupMember() {
        //Given
        long memberId = 1;

        //When
        studyGroupMemberService.deleteStudyGroupMember(memberId);
        System.out.println("DELETE SUCCESS");

        //Then
        Assertions.assertTrue(studyGroupMemberRepository.findById(memberId).isEmpty());
    }
}
