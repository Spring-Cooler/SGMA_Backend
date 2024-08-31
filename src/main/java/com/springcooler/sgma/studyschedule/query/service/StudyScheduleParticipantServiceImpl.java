package com.springcooler.sgma.studyschedule.query.service;

import com.springcooler.sgma.studyschedule.query.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyschedule.query.repository.StudyScheduleParticipantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyScheduleParticipantServiceImpl implements StudyScheduleParticipantService
{
    private final StudyScheduleParticipantMapper studyScheduleParticipantMapper;

    @Autowired
    public StudyScheduleParticipantServiceImpl(StudyScheduleParticipantMapper studyScheduleParticipantMapper) {
        this.studyScheduleParticipantMapper = studyScheduleParticipantMapper;
    }

    // 스터디 그룹 일정 참가자 조회
    @Override
    public List<StudyScheduleParticipantDTO> findStudyScheduleParticipant(long scheduleId) {
        return studyScheduleParticipantMapper.findStudyScheduleParticipant(scheduleId);
    }

    // 스터디 그룹 일정 참가자의 시험 조회
    @Override
    public List<StudyScheduleParticipantDTO> findStudyScheduleParticipantTestResult(long memberId) {
        return studyScheduleParticipantMapper.findStudyScheduleParticipantTestResult(memberId);
    }

}
