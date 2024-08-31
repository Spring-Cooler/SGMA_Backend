package com.springcooler.sgma.recruitmentboard.query.service;

import com.springcooler.sgma.recruitmentboard.query.dto.RecruitmentBoardDTO;
import com.springcooler.sgma.recruitmentboard.query.repository.RecruitmentBoardMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.springcooler.sgma.studygroupapplicant.common.Template.getSqlSession;


@Service
@Log4j2
public class RecruitmentBoardService {

    private RecruitmentBoardMapper recruitmentBoardMapper;
    public List<RecruitmentBoardDTO> studyGroupRecruitment() {
        SqlSession sqlSession = getSqlSession();
        RecruitmentBoardMapper mapper = sqlSession.getMapper(RecruitmentBoardMapper.class);
        List<RecruitmentBoardDTO> studyGroupApplicantDTOS = mapper.studyGroupRecruitment();
        return studyGroupApplicantDTOS;
    }

    public RecruitmentBoardDTO selectStudyGroupApplicantById(Long recruitmentBoardId){
        SqlSession sqlSession =getSqlSession();
        recruitmentBoardMapper =sqlSession.getMapper(RecruitmentBoardMapper.class);
//        RecruitmentBoardDTO studyGroupApplicant = recruitmentBoardMapper.selectStudyGroupApplicantDTO(recruitmentBoardId);
//        return studyGroupApplicant;
        RecruitmentBoardDTO recruitmentBoardDTO = recruitmentBoardMapper.selectStudyGroupApplicantDTO(recruitmentBoardId);
        return recruitmentBoardDTO;
    }
}
