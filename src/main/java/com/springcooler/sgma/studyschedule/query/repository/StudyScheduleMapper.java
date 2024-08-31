package com.springcooler.sgma.studyschedule.query.repository;

import com.springcooler.sgma.studyschedule.query.dto.StudyScheduleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyScheduleMapper {

    // 스터디 그룹 일정 전체 조회 (groupID로 조회)
    List<StudyScheduleDTO> findStudyScheduleByGroupId(long groupId);

    // 스터디 그룹 일정 단건 조회 (scheduleID로 조회)
    List<StudyScheduleDTO> findStudyScheduleByScheduleId(long scheduleId);
}