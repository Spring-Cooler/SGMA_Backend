package com.springcooler.sgma.studygroupboardcomment.query.service;

import com.springcooler.sgma.studygroupboardcomment.query.dto.StudyGroupBoardCommentDTO;

import java.util.List;

public interface StudyGroupBoardCommentService {

    List<StudyGroupBoardCommentDTO> findStudyGroupBoardCommentsByBoardId(Long boardId);

    List<StudyGroupBoardCommentDTO> findStudyGroupBoardCommentsByMemberId(Long memberId);

}
