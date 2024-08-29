package com.springcooler.sgma.studygroupmember.command.application.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;

public interface AppStudyGroupMemberService {

    StudyGroupMember registStudyGroupOwner(StudyGroupMemberDTO owner);

    StudyGroupMember registStudyGroupMember(StudyGroupMemberDTO newMember);

    StudyGroupMember modifyStudyGroupMember(StudyGroupMemberDTO modifyMember);

    void deleteStudyGroupMember(long memberId);

}
