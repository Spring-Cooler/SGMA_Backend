package com.springcooler.sgma.studygroupmember.command.domain.service;

import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMemberStatus;
import org.springframework.stereotype.Service;

@Service
public class DomainStudyGroupMemberServiceImpl implements DomainStudyGroupMemberService {

    @Override
    public boolean isActive(StudyGroupMemberStatus memberStatus) {
        return memberStatus.equals(StudyGroupMemberStatus.ACTIVE);
    }

}
