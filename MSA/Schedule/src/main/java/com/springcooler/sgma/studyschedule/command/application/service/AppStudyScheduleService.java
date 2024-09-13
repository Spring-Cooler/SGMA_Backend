package com.springcooler.sgma.studyschedule.command.application.service;

import com.springcooler.sgma.studyschedule.command.application.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;

public interface AppStudyScheduleService {

    // 스터디 일정 생성
    StudyScheduleDTO registStudySchedule(StudyScheduleDTO createStudySchedule);

    // 스터디 일정 수정
    StudyScheduleDTO modifyStudySchedule(StudyScheduleDTO updateStudySchedule);

    // 스터디 일정 삭제
    void deleteStudySchedule(Long scheduleId);
}
