package com.springcooler.sgma.studygroup.command.infrastructure.service;

import com.springcooler.sgma.studygroupmember.command.application.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.command.application.service.AppStudyGroupMemberService;
import com.springcooler.sgma.studygroupmember.command.domain.aggregate.StudyGroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfraStudyGroupServiceImpl implements InfraStudyGroupService {

    private final AppStudyGroupMemberService studyGroupMemberService;

    @Autowired
    public InfraStudyGroupServiceImpl(AppStudyGroupMemberService studyGroupMemberService) {
        this.studyGroupMemberService = studyGroupMemberService;
    }

    @Override
    public StudyGroupMember registStudyGroupOwner(StudyGroupMemberDTO owner) {
        return studyGroupMemberService.registStudyGroupOwner(owner);
    }

}
