package com.springcooler.sgma.studygroupboardlike.query.service;

import com.springcooler.sgma.studygroupboardlike.common.exception.CommonException;
import com.springcooler.sgma.studygroupboardlike.common.exception.ErrorCode;
import com.springcooler.sgma.studygroupboardlike.query.dto.StudyGroupBoardLikeDTO;
import com.springcooler.sgma.studygroupboardlike.query.repository.StudyGroupBoardLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupBoardLikeServiceImpl implements StudyGroupBoardLikeService {

    private final StudyGroupBoardLikeMapper studyGroupBoardLikeMapper;

    @Autowired
    public StudyGroupBoardLikeServiceImpl(StudyGroupBoardLikeMapper studyGroupBoardLikeMapper) {
        this.studyGroupBoardLikeMapper = studyGroupBoardLikeMapper;
    }

    @Override
    public List<StudyGroupBoardLikeDTO> findStudyGroupBoardLikesByBoardId(Long boardId) {
        List<StudyGroupBoardLikeDTO> likes = studyGroupBoardLikeMapper.findStudyGroupBoardLikesByBoardId(boardId);
        if(likes == null || likes.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_LIKE);
        }
        return likes;
    }

    @Override
    public List<StudyGroupBoardLikeDTO> findStudyGroupBoardLikesByMemberId(Long memberId) {
        List<StudyGroupBoardLikeDTO> likes = studyGroupBoardLikeMapper.findStudyGroupBoardLikesByMemberId(memberId);
        if(likes == null || likes.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_LIKE);
        }
        return likes;
    }

}
