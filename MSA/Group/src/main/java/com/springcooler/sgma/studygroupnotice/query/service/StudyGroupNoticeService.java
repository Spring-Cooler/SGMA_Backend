package com.springcooler.sgma.studygroupnotice.query.service;

import com.springcooler.sgma.studygroupnotice.query.dto.StudyGroupNoticeDTO;

import java.util.List;

public interface StudyGroupNoticeService {

    // 스터디그룹 공지사항 전체 조회(스터디그룹 아이디)
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByGroupId(Long groupId, Integer pageNo);

    // 스터디그룹 공지사항 단건 조회(공지사항 아이디)
    StudyGroupNoticeDTO findStudyGroupNoticeByNoticeId(Long noticeId);

    // 스터디그룹 공지사항 제목으로 조회
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByTitle(String title, Integer pageNo);

    // 스터디그룹 공지사항 내용으로 조회
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByContent(String content, Integer pageNo);

}
