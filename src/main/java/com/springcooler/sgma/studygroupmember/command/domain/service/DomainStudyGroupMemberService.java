package com.springcooler.sgma.studygroupmember.command.domain.service;

import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMemberStatus;

public interface DomainStudyGroupMemberService {

    boolean isActive(StudyGroupMemberStatus memberStatus);

}
