package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;
import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;

public interface AppStudyGroupService {
    // 스터디 그룹 생성
    StudyGroup registStudyGroup(StudyGroupDTO newStudyGroup);

    // 스터디 그룹장 신청 승인
    StudyGroup registAcceptedMember(StudyGroupMemberDTO acceptStudyGroupMember);

    // 스터디 그룹 정보 수정
    StudyGroup modifyStudyGroup(StudyGroupDTO modifyStudyGroup);

    // 스터디 그룹 이름 수정
    StudyGroup modifyStudyGroupName(StudyGroupDTO modifyStudyGroup);

    // 스터디 그룹 카테고리 수정
    StudyGroup modifyStudyGroupCategory(StudyGroupDTO modifyStudyGroup);

    // 스터디 그룹원 탈퇴
    StudyGroup deleteQuitMember(long memberId, long groupId);

    // 스터디 그룹 삭제
    void deleteStudyGroup(long groupId);
}
