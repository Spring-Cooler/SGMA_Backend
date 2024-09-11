package com.springcooler.sgma.studygroupboard.query.service;

import com.springcooler.sgma.studygroupboard.query.dto.StudyGroupBoardDTO;

import java.util.List;

public interface StudyGroupBoardService {

    // 게시글 그룹별 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByGroupId(Long groupId);

    // 게시글 그룹원별 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByMemberId(Long memberId);

    // 게시글 제목으로 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByTitle(String title);

    // 게시글 내용으로 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByContent(String content);

    // 게시글 단건 조회
    StudyGroupBoardDTO findStudyGroupBoardByBoardId(Long boardId);

}
