package com.springcooler.sgma.recruitmentboard.query.repository;

import com.springcooler.sgma.recruitmentboard.query.dto.RecruitmentBoardDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface RecruitmentBoardMapper {

    List<RecruitmentBoardDTO> findAllRecruitmentBoards();

    RecruitmentBoardDTO findRecruitmentBoardByBoardId(Long recruitmentBoardId);

}
