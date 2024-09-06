package com.springcooler.sgma.studygroupboard.query.repository;

import com.springcooler.sgma.studygroupboard.query.dto.StudyGroupBoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyGroupBoardMapper {

    // 게시글 그룹별 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByGroupId(Long groupId);

    // 게시글 그룹원별 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByMemberId(Long memberId);

    // 게시글 제목으로 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByTitle(String title);

    // 게시글 단건 조회
    StudyGroupBoardDTO findStudyGroupBoardByBoardId(Long boardId);

}
