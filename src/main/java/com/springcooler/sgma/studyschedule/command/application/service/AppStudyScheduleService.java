package com.springcooler.sgma.studyschedule.command.application.service;

import com.springcooler.sgma.studyschedule.command.application.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;

import java.util.Map;

public interface AppStudyScheduleService {

    // 스터디 일정 생성
    StudySchedule registStudySchedule(StudyScheduleDTO createStudySchedule);

    // 스터디 일정 수정
    StudySchedule modifyStudySchedule(Long scheduleId, StudyScheduleDTO updateStudySchedule);

    // 스터디 일정 삭제
    void deleteStudySchedule(long scheduleId);

    // 일정에 따른 참가자들의 시험 평균 및 표준편차 계산 및 업데이트
    void updateScheduleWithParticipantScores(Long scheduleId);
}
