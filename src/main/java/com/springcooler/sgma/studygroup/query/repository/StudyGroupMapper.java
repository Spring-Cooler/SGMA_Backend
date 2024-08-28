package com.springcooler.sgma.studygroup.query.repository;

import com.springcooler.sgma.studygroup.query.dto.StudyGroupDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyGroupMapper {
    List<StudyGroupDTO> findAllStudyGroupsByActiveStatus(String activeStatus);
}
