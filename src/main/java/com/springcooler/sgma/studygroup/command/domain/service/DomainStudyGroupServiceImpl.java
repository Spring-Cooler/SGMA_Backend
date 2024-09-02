package com.springcooler.sgma.studygroup.command.domain.service;

import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroupStatus;
import org.springframework.stereotype.Service;

@Service
public class DomainStudyGroupServiceImpl implements DomainStudyGroupService {

    @Override
    public boolean isActive(StudyGroupStatus groupStatus) {
        return groupStatus.equals(StudyGroupStatus.ACTIVE);
    }

}
