package com.springcooler.sgma.studygroup.command.domain.service;

import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroupStatus;
import org.springframework.stereotype.Service;

@Service
public class DomainStudyGroupService {

    public boolean isActive(String groupStatus) {
        return groupStatus.equals(StudyGroupStatus.ACTIVE.name());
    }

}
