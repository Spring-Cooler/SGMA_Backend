package com.springcooler.sgma.studygroup.query.repository;

import com.springcooler.sgma.studygroup.query.dto.StudyGroupDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyGroupMapper {
    List<StudyGroupDTO> findAllStudyGroups();

    List<StudyGroupDTO> findStudyGroupsByOwnerId(long ownerId);

    List<StudyGroupDTO> findStudyGroupsByParticipantId(long participantId);

    List<StudyGroupDTO> findStudyGroupsByCategoryId(int categoryId);

    List<StudyGroupDTO> findStudyGroupByGroupId(long groupId);

    List<StudyGroupDTO> findStudyGroupByGroupName(String groupName);
}
