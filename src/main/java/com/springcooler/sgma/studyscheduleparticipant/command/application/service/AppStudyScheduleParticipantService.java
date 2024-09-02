package com.springcooler.sgma.studyscheduleparticipant.command.application.service;

import com.springcooler.sgma.problem.query.common.ResponseMessage;
import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;

import java.util.Map;

public interface AppStudyScheduleParticipantService {

    // 스터디 그룹 일정 참가
    StudySchedule registStudyScheduleParticipant(StudyScheduleParticipantDTO newParticipant);

    // 스터디 그룹 일정 참가 취소
    void deleteStudyScheduleParticipant(Long scheduleId, Long memberId);

    // 출제 문제 수 업데이트
//    ResponseMessage updateParticipantProblemCount(Long scheduleId, Long memberId);

    // 참가자의 시험 점수와 백분율 계산
//    Map<String, Double> calculateParticipantScore(Long scheduleId, Long memberId);
}
