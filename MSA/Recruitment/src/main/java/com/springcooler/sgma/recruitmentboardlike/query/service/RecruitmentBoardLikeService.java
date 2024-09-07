package com.springcooler.sgma.recruitmentboardlike.query.service;

import com.springcooler.sgma.recruitmentboardlike.query.dto.RecruitmentBoardLikeDTO;
import com.springcooler.sgma.recruitmentboardlike.query.repository.RecruitmentBoardLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentBoardLikeService {
    private final RecruitmentBoardLikeMapper recruitmentBoardLikeMapper;

    @Autowired
    public RecruitmentBoardLikeService(RecruitmentBoardLikeMapper recruitmentBoardLikeMapper) {
        this.recruitmentBoardLikeMapper = recruitmentBoardLikeMapper;
    }

    public List<RecruitmentBoardLikeDTO> findAllRecruitmentBoardLike() {
        List<RecruitmentBoardLikeDTO> likes = recruitmentBoardLikeMapper.findrecruitmentBoardLike();
        return likes;
    }
}
