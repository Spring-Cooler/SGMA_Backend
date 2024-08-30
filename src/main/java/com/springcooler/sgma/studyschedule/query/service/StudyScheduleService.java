package com.springcooler.sgma.studyschedule.query.service;

import com.springcooler.sgma.studyschedule.query.dto.StudyScheduleDTO;

import java.util.List;

public interface StudyScheduleService {

    // 스터디 그룹 일정 단건 조회 (일정 ID로 조회)
    List<StudyScheduleDTO> findStudyScheduleByScheduleId(long scheduleId);

}