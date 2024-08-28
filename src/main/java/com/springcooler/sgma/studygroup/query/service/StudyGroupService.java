package com.springcooler.sgma.studygroup.query.service;

import com.springcooler.sgma.studygroup.query.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.query.repository.StudyGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupService {
    private final StudyGroupMapper studyGroupMapper;

    @Autowired
    public StudyGroupService(StudyGroupMapper studyGroupMapper) {
        this.studyGroupMapper = studyGroupMapper;
    }

    public List<StudyGroupDTO> findAllStudyGroups() {
        return studyGroupMapper.findAllStudyGroups();
    }

    public List<StudyGroupDTO> findStudyGroupsByOwnerId(Long ownerId) {
        return studyGroupMapper.findStudyGroupsByOwnerId(ownerId);
    }

    public List<StudyGroupDTO> findStudyGroupsByParticipantId(Long participantId) {
        return studyGroupMapper.findStudyGroupsByParticipantId(participantId);
    }

    public List<StudyGroupDTO> findStudyGroupsByCategoryId(int categoryId) {
        return studyGroupMapper.findStudyGroupsByCategoryId(categoryId);
    }

    public List<StudyGroupDTO> findStudyGroupByGroupId(long groupId) {
        return studyGroupMapper.findStudyGroupByGroupId(groupId);
    }
}
