package com.springcooler.sgma.recruitmentboardlike.query.repository;

import com.springcooler.sgma.recruitmentboardlike.query.dto.RecruitmentBoardLikeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitmentBoardLikeMapper {

    List<RecruitmentBoardLikeDTO> findrecruitmentBoardLike();
}
