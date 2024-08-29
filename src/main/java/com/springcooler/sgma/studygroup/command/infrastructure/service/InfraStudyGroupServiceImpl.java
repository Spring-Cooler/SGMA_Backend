package com.springcooler.sgma.studygroup.command.infrastructure.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.application.service.StudyGroupMemberService;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfraStudyGroupServiceImpl implements InfraStudyGroupService {

    private final StudyGroupMemberService studyGroupMemberService;

    @Autowired
    public InfraStudyGroupServiceImpl(StudyGroupMemberService studyGroupMemberService) {
        this.studyGroupMemberService = studyGroupMemberService;
    }

    @Override
    public StudyGroupMember registStudyGroupOwner(StudyGroupMemberDTO owner) {
        return studyGroupMemberService.registStudyGroupOwner(owner);
    }

}
