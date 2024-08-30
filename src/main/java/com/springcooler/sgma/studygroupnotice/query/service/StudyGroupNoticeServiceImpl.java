package com.springcooler.sgma.studygroupnotice.query.service;

import com.springcooler.sgma.studygroupnotice.query.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.query.repository.StudyGroupNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupNoticeServiceImpl implements StudyGroupNoticeService {

    private final StudyGroupNoticeMapper studyGroupNoticeMapper;

    @Autowired
    public StudyGroupNoticeServiceImpl(StudyGroupNoticeMapper studyGroupNoticeMapper) {
        this.studyGroupNoticeMapper = studyGroupNoticeMapper;
    }

    // 스터디그룹 공지사항 전체 조회(스터디그룹 아이디)
    @Override
    public List<StudyGroupNoticeDTO> findStudyGroupNoticesByGroupId(long groupId) {
        return studyGroupNoticeMapper.findStudyGroupNoticesByGroupId(groupId);
    }

    // 스터디그룹 공지사항 단건 조회(공지사항 아이디)
    @Override
    public List<StudyGroupNoticeDTO> findStudyGroupNoticeByNoticeId(long noticeId) {
        return studyGroupNoticeMapper.findStudyGroupNoticeByNoticeId(noticeId);
    }

}
