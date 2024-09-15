package com.springcooler.sgma.recruitmentboard.query.service;

import com.springcooler.sgma.recruitmentboard.common.exception.CommonException;
import com.springcooler.sgma.recruitmentboard.common.exception.ErrorCode;
import com.springcooler.sgma.recruitmentboard.query.dto.RecruitmentBoardDTO;
import com.springcooler.sgma.recruitmentboard.query.repository.RecruitmentBoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RecruitmentBoardService {

    private final RecruitmentBoardMapper recruitmentBoardMapper;

    @Autowired
    public RecruitmentBoardService(RecruitmentBoardMapper recruitmentBoardMapper) {
        this.recruitmentBoardMapper = recruitmentBoardMapper;
    }

    public List<RecruitmentBoardDTO> findAllRecruitmentBoards() {
        List<RecruitmentBoardDTO> recruitmentBoards = recruitmentBoardMapper.findAllRecruitmentBoards();
        if(recruitmentBoards == null || recruitmentBoards.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_RECRUITMENT_BOARD);
        }
        return recruitmentBoards;
    }

    public RecruitmentBoardDTO findRecruitmentBoardByBoardId(Long recruitmentBoardId){
        RecruitmentBoardDTO recruitmentBoard =
                recruitmentBoardMapper.findRecruitmentBoardByBoardId(recruitmentBoardId);
        if(recruitmentBoard == null) {
            throw new CommonException(ErrorCode.NOT_FOUND_RECRUITMENT_BOARD);
        }
        return recruitmentBoard;
    }

    public List<RecruitmentBoardDTO> findRecruitmentBoardsByTitle(String title){
        List<RecruitmentBoardDTO> recruitmentBoards = recruitmentBoardMapper.findRecruitmentBoardsByTitle(title);
        if(recruitmentBoards == null) {
            throw new CommonException(ErrorCode.NOT_FOUND_RECRUITMENT_BOARD);
        }
        return recruitmentBoards;
    }

}
