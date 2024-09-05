package com.springcooler.sgma.recruitmentboardreply.query.service;

import com.springcooler.sgma.recruitmentboardreply.query.dto.RecruitmentBoardReplyDTO;
import com.springcooler.sgma.recruitmentboardreply.query.repository.RecruitmentBoardReplyMapper;

import com.springcooler.sgma.studygroupapplicant.common.exception.CommonException;
import com.springcooler.sgma.studygroupapplicant.common.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentBoardReplyService {

    private final RecruitmentBoardReplyMapper recruitmentBoardReplyMapper;

    @Autowired
    public RecruitmentBoardReplyService(RecruitmentBoardReplyMapper recruitmentBoardReplyMapper) {
        this.recruitmentBoardReplyMapper = recruitmentBoardReplyMapper;
    }

    public List<RecruitmentBoardReplyDTO> getAllRecruitmentBoardReply(){
        List<RecruitmentBoardReplyDTO> replies =recruitmentBoardReplyMapper.findRecruitmentBoardReplies();
        if(replies == null || replies.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_RECRUITMENT_BOARD_REPLY);
        }
        return replies;
    }

}
