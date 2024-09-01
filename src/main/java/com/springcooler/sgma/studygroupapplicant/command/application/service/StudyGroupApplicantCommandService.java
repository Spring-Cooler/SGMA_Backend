package com.springcooler.sgma.studygroupapplicant.command.application.service;

import com.springcooler.sgma.studygroupapplicant.command.application.dto.StudyGroupApplicantCommandDTO;
import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.StudyGroupApplicant;


public interface StudyGroupApplicantCommandService {

    // 스터디 그룹 신청
    StudyGroupApplicant applyStudyGroup(StudyGroupApplicantCommandDTO studyGroupApplicantCommandDTO);

    // 스터디 그룹 신청 취소
   void cancelStudyGroupApply(long userId);


}
