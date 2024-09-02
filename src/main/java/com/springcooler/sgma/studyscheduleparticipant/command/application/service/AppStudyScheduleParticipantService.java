package com.springcooler.sgma.studyscheduleparticipant.command.application.service;

import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;

public interface AppStudyScheduleParticipantService {

    // 스터디 그룹 일정 참가
    StudySchedule registStudyScheduleParticipant(StudyScheduleParticipantDTO newParticipant);

    // 스터디 그룹 일정 참가 취소
    void deleteStudyScheduleParticipant(Long scheduleId, Long memberId);
}
