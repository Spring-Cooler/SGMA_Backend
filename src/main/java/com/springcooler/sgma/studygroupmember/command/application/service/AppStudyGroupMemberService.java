package com.springcooler.sgma.studygroupmember.command.application.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;

public interface AppStudyGroupMemberService {
    // 스터디 그룹원 추가
    StudyGroupMember registStudyGroupMember(StudyGroupMemberDTO newMember);

    // 스터디 그룹원 정보 수정
    StudyGroupMember modifyStudyGroupMember(StudyGroupMemberDTO modifyMember);

    // 스터디 그룹원 삭제
    void deleteStudyGroupMember(long memberId);

}
