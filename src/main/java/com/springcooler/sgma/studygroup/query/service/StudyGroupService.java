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

    // 스터디 그룹 전체 조회
    public List<StudyGroupDTO> findAllStudyGroups() {
        return studyGroupMapper.findAllStudyGroups();
    }

    // 생성한 스터디 그룹 조회
    public List<StudyGroupDTO> findStudyGroupsByOwnerId(Long ownerId) {
        return studyGroupMapper.findStudyGroupsByOwnerId(ownerId);
    }

    // 참가한 스터디 그룹 조회
    public List<StudyGroupDTO> findStudyGroupsByParticipantId(Long participantId) {
        return studyGroupMapper.findStudyGroupsByParticipantId(participantId);
    }

    // 스터디 그룹 카테고리별 조회
    public List<StudyGroupDTO> findStudyGroupsByCategoryId(int categoryId) {
        return studyGroupMapper.findStudyGroupsByCategoryId(categoryId);
    }

    // 스터디 그룹 단건 조회
    public List<StudyGroupDTO> findStudyGroupByGroupId(long groupId) {
        return studyGroupMapper.findStudyGroupByGroupId(groupId);
    }
}
