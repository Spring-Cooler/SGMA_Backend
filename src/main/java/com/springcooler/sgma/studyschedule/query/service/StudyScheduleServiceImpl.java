package com.springcooler.sgma.studyschedule.query.service;

import com.springcooler.sgma.studyschedule.query.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.query.repository.StudyScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyScheduleServiceImpl implements StudyScheduleService {
    private final StudyScheduleMapper studyScheduleMapper;

    @Autowired
    public StudyScheduleServiceImpl(StudyScheduleMapper studyScheduleMapper) {
        this.studyScheduleMapper = studyScheduleMapper;
    }

    // 스터디 그룹 일정 단건 조회 (일정 ID로 조회)
    @Override
    public List<StudyScheduleDTO> findStudyScheduleByScheduleId(long scheduleId) {
        return studyScheduleMapper.findStudyScheduleByScheduleId(scheduleId);
    }
}