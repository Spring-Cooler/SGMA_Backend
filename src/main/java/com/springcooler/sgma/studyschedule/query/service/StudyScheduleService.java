package com.springcooler.sgma.studyschedule.query.service;

import com.springcooler.sgma.studyschedule.query.dto.StudyScheduleDTO;

import java.util.List;

public interface StudyScheduleService {
    // 스터디 그룹 일정 전체 조회 (그룹 ID로 조회)
    List<StudyScheduleDTO> findStudyScheduleByGroupId(long groupId);

    // 스터디 그룹 일정 단건 조회 (일정 ID로 조회)
    List<StudyScheduleDTO> findStudyScheduleByScheduleId(long scheduleId);

    // 스터디 그룹 일정 기간별 조회 (시작 날짜와 종료 날짜로 조회)
//    List<StudyScheduleDTO> findStudySchedulesByPeriod(String startDate, String endDate);

    // 스터디 그룹 일정 시험의 통계 자료 조회 (시험 ID로 조회)
//    List<StudyScheduleDTO> findStudyScheduleStatisticsByTestId(long testId);
}