package com.springcooler.sgma.studygroupmember.command.domain.service;

import org.springframework.stereotype.Service;

@Service
public class DomainStudyGroupMemberService {

    public boolean isActive(String memberStatus) {
        return memberStatus.equals("ACTIVE");
    }

}
