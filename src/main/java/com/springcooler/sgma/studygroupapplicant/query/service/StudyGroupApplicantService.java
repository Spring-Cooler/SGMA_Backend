package com.springcooler.sgma.studygroupapplicant.query.service;



import com.springcooler.sgma.studygroupapplicant.query.dto.StudyGroupApplicantDTO;
import com.springcooler.sgma.studygroupapplicant.query.repository.StudyGroupApplicantMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.springcooler.sgma.studygroupapplicant.common.Template.getSqlSession;


@Service
@Log4j2
public class StudyGroupApplicantService {
    public List<StudyGroupApplicantDTO> studyGroupRecruitmentTest() {
        SqlSession sqlSession = getSqlSession();
        StudyGroupApplicantMapper mapper = sqlSession.getMapper(StudyGroupApplicantMapper.class);
        List<StudyGroupApplicantDTO> inapplicability = mapper.studyGroupRecruitmentTest();
        return inapplicability;

    }
}
