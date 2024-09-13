package com.springcooler.sgma.studygroupboard.query.service;

import com.springcooler.sgma.studygroupboard.common.exception.CommonException;
import com.springcooler.sgma.studygroupboard.common.exception.ErrorCode;
import com.springcooler.sgma.studygroupboard.query.dto.StudyGroupBoardDTO;
import com.springcooler.sgma.studygroupboard.query.repository.StudyGroupBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupBoardServiceImpl implements StudyGroupBoardService {

    private final Integer PAGE_SIZE = 10;

    private final StudyGroupBoardMapper studyGroupBoardMapper;

    @Autowired
    public StudyGroupBoardServiceImpl(StudyGroupBoardMapper studyGroupBoardMapper) {
        this.studyGroupBoardMapper = studyGroupBoardMapper;
    }

    // 게시글 그룹별 조회
    @Override
    public List<StudyGroupBoardDTO> findStudyGroupBoardsByGroupId(Long groupId, Integer pageNo) {
        if(pageNo == null || pageNo < 1) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER_FORMAT);
        }
        Integer offset = (pageNo - 1) * PAGE_SIZE;
        List<StudyGroupBoardDTO> boards = studyGroupBoardMapper.findStudyGroupBoardsByGroupId(groupId, PAGE_SIZE, offset);
        if(boards == null || boards.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_BOARD);
        }
        return boards;
    }

    // 게시글 그룹원별 조회
    @Override
    public List<StudyGroupBoardDTO> findStudyGroupBoardsByMemberId(Long memberId, Integer pageNo) {
        if(pageNo == null || pageNo < 1) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER_FORMAT);
        }
        Integer offset = (pageNo - 1) * PAGE_SIZE;
        List<StudyGroupBoardDTO> boards = studyGroupBoardMapper.findStudyGroupBoardsByMemberId(memberId, PAGE_SIZE, offset);
        if(boards == null || boards.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_BOARD);
        }
        return boards;
    }

    // 게시글 제목으로 조회
    @Override
    public List<StudyGroupBoardDTO> findStudyGroupBoardsByTitle(String title, Integer pageNo) {
        if(pageNo == null || pageNo < 1) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER_FORMAT);
        }
        Integer offset = (pageNo - 1) * PAGE_SIZE;
        List<StudyGroupBoardDTO> boards = studyGroupBoardMapper.findStudyGroupBoardsByTitle(title, PAGE_SIZE, offset);
        if(boards == null || boards.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_BOARD);
        }
        return boards;
    }

    // 게시글 내용으로 조회
    @Override
    public List<StudyGroupBoardDTO> findStudyGroupBoardsByContent(String content, Integer pageNo) {
        if(pageNo == null || pageNo < 1) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER_FORMAT);
        }
        Integer offset = (pageNo - 1) * PAGE_SIZE;
        List<StudyGroupBoardDTO> boards = studyGroupBoardMapper.findStudyGroupBoardsByContent(content, PAGE_SIZE, offset);
        if(boards == null || boards.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_BOARD);
        }
        return boards;
    }

    // 게시글 단건 조회
    @Override
    public StudyGroupBoardDTO findStudyGroupBoardByBoardId(Long boardId) {
        StudyGroupBoardDTO board = studyGroupBoardMapper.findStudyGroupBoardByBoardId(boardId);
        if (board == null) {
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_BOARD);
        }
        return board;
    }

}
