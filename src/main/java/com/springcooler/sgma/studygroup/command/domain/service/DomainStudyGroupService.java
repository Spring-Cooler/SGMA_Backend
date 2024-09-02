package com.springcooler.sgma.studygroup.command.domain.service;

import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroupStatus;

public interface DomainStudyGroupService {

    boolean isActive(StudyGroupStatus groupStatus);

}
