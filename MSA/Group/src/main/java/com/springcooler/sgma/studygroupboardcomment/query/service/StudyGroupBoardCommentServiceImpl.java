package com.springcooler.sgma.studygroupboardcomment.query.service;

import com.springcooler.sgma.studygroupboardcomment.common.exception.CommonException;
import com.springcooler.sgma.studygroupboardcomment.common.exception.ErrorCode;
import com.springcooler.sgma.studygroupboardcomment.query.dto.StudyGroupBoardCommentDTO;
import com.springcooler.sgma.studygroupboardcomment.query.repository.StudyGroupBoardCommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupBoardCommentServiceImpl implements StudyGroupBoardCommentService {

    private final StudyGroupBoardCommentMapper studyGroupBoardCommentMapper;

    public StudyGroupBoardCommentServiceImpl(StudyGroupBoardCommentMapper studyGroupBoardCommentMapper) {
        this.studyGroupBoardCommentMapper = studyGroupBoardCommentMapper;
    }

    @Override
    public List<StudyGroupBoardCommentDTO> findStudyGroupBoardCommentsByBoardId(Long boardId) {
        List<StudyGroupBoardCommentDTO> comments =
                studyGroupBoardCommentMapper.findStudyGroupBoardCommentsByBoardId(boardId);
        if(comments == null || comments.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_BOARD_COMMENT);
        }
        return comments;
    }

    @Override
    public List<StudyGroupBoardCommentDTO> findStudyGroupBoardCommentsByMemberId(Long memberId) {
        List<StudyGroupBoardCommentDTO> comments =
                studyGroupBoardCommentMapper.findStudyGroupBoardCommentsByMemberId(memberId);
        if(comments == null || comments.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_BOARD_COMMENT);
        }
        return comments;
    }

}
