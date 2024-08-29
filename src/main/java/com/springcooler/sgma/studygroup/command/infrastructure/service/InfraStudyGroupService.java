package com.springcooler.sgma.studygroup.command.infrastructure.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;

public interface InfraStudyGroupService {

    StudyGroupMember registStudyGroupOwner(StudyGroupMemberDTO owner);

}
