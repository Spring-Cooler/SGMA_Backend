package com.springcooler.sgma.studygroup.query.service;

import com.springcooler.sgma.studygroup.query.dto.StudyGroupDTO;
import com.springcooler.sgma.studygroup.query.repository.StudyGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupServiceImpl implements StudyGroupService {
    private final StudyGroupMapper studyGroupMapper;

    @Autowired
    public StudyGroupServiceImpl(StudyGroupMapper studyGroupMapper) {
        this.studyGroupMapper = studyGroupMapper;
    }

    // 스터디 그룹 전체 조회
    @Override
    public List<StudyGroupDTO> findAllStudyGroups() {
        return studyGroupMapper.findAllStudyGroups();
    }

    // 그룹장인 스터디 그룹 조회
    @Override
    public List<StudyGroupDTO> findStudyGroupsByOwnerId(Long ownerId) {
        return studyGroupMapper.findStudyGroupsByOwnerId(ownerId);
    }

    // 그룹원인 스터디 그룹 조회
    @Override
    public List<StudyGroupDTO> findStudyGroupsByParticipantId(Long participantId) {
        return studyGroupMapper.findStudyGroupsByParticipantId(participantId);
    }

    // 스터디 그룹 카테고리별 조회
    @Override
    public List<StudyGroupDTO> findStudyGroupsByCategoryId(int categoryId) {
        return studyGroupMapper.findStudyGroupsByCategoryId(categoryId);
    }

    // 스터디 그룹 단건 조회(그룹 아이디)
    @Override
    public List<StudyGroupDTO> findStudyGroupByGroupId(long groupId) {
        return studyGroupMapper.findStudyGroupByGroupId(groupId);
    }

    // 스터디 그룹 단건 조회(그룹 이름)
    @Override
    public List<StudyGroupDTO> findStudyGroupByGroupName(String groupName) {
        return studyGroupMapper.findStudyGroupByGroupName(groupName);
    }
}
