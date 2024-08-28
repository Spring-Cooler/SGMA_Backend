package com.springcooler.sgma.studygroupmember.query.service;

import com.springcooler.sgma.studygroupmember.query.dto.StudyGroupMemberDTO;
import com.springcooler.sgma.studygroupmember.query.repository.StudyGroupMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupMemberServiceImpl implements StudyGroupMemberService {

    private final StudyGroupMemberMapper studyGroupMemberMapper;

    @Autowired
    public StudyGroupMemberServiceImpl(StudyGroupMemberMapper studyGroupMemberMapper) {
        this.studyGroupMemberMapper = studyGroupMemberMapper;
    }

    // 스터디 그룹원 단건 조회(그룹원 아이디)
    @Override
    public List<StudyGroupMemberDTO> findStudyGroupMemberByMemberId(long memberId) {
        return studyGroupMemberMapper.findStudyGroupMemberByMemberId(memberId);
    }

    // 스터디 그룹원 그룹별 조회
    @Override
    public List<StudyGroupMemberDTO> findStudyGroupMembersByGroupId(long groupId) {
        return studyGroupMemberMapper.findStudyGroupMembersByGroupId(groupId);
    }
}
