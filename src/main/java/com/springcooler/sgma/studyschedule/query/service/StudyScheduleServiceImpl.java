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

    // 스터디 그룹 일정 단건 조회
    @Override
    public List<StudyScheduleDTO> findStudyScheduleByScheduleId(long scheduleId) {
        return studyScheduleMapper.findStudyScheduleByScheduleId(scheduleId);
    }

    // 스터디 그룹 일정 전체 조회
    @Override
    public List<StudyScheduleDTO> findStudyScheduleByGroupId(long groupId) {
        return studyScheduleMapper.findStudyScheduleByGroupId(groupId);
    }

    // 스터디 그룹 일정 기간별 조회
    @Override
    public List<StudyScheduleDTO> findStudySchedulesByPeriod(long groupId, String startDate, String endDate) {
        return studyScheduleMapper.findStudySchedulesByPeriod(groupId, startDate, endDate);
    }

    // 스터디 그룹 일정 시험의 통계 자료 조회
    @Override
    public StudyScheduleDTO findStudyScheduleByStatistics(long scheduleId) {
        return studyScheduleMapper.findStudyScheduleByStatistics(scheduleId);
    }
}
