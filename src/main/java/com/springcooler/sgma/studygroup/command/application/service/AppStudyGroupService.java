package com.springcooler.sgma.studygroup.command.application.service;

import com.springcooler.sgma.studygroup.command.application.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.command.domain.aggregate.StudyGroup;

public interface AppStudyGroupService {

    StudyGroup registStudyGroup(StudyGroupDTO newStudyGroup);

    StudyGroup modifyStudyGroup(StudyGroupDTO modifyStudyGroup);

    void deleteStudyGroup(long groupId);
}
