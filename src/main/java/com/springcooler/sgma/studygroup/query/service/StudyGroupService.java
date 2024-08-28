package com.springcooler.sgma.studygroup.query.service;

import com.springcooler.sgma.studygroup.query.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.query.repository.StudyGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudyGroupService {
    private final StudyGroupMapper studyGroupMapper;

    @Autowired
    public StudyGroupService(StudyGroupMapper studyGroupMapper) {
        this.studyGroupMapper = studyGroupMapper;
    }

    public List<StudyGroupDTO> findAllStudyGroupsByActiveStatus(String activeStatus) {
        return studyGroupMapper.findAllStudyGroupsByActiveStatus(activeStatus);
    }
}
