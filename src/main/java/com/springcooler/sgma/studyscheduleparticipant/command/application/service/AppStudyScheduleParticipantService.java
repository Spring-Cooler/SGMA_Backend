package com.springcooler.sgma.studyscheduleparticipant.command.application.service;

import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;


public interface AppStudyScheduleParticipantService {

    // 스터디 그룹 일정 참가
    StudyScheduleParticipant registStudyScheduleParticipant(StudyScheduleParticipantDTO newParticipant);

    // 스터디 그룹 일정 참가 취소
    void deleteStudyScheduleParticipant(Long scheduleId, Long memberId);

    // 출제 문제수 및 출제 상태 변경
    void increaseNumSubmittedProblems(Long scheduleId, Long memberId);

    void decreaseNumSubmittedProblems(Long scheduleId, Long participantId);

    // 참가자의 시험 점수와 백분율 계산
//    void calculateAndUpdateParticipantScores(Long scheduleId);
}
