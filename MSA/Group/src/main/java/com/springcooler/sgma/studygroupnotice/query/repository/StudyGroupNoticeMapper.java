package com.springcooler.sgma.studygroupnotice.query.repository;

import com.springcooler.sgma.studygroupnotice.query.dto.StudyGroupNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyGroupNoticeMapper {

    // 스터디그룹 공지사항 전체 조회(스터디그룹 아이디)
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByGroupId(Long groupId);

    // 스터디그룹 공지사항 단건 조회(공지사항 아이디)
    StudyGroupNoticeDTO findStudyGroupNoticeByNoticeId(Long noticeId);

    // 스터디그룹 공지사항 제목으로 조회
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByTitle(String title);

    // 스터디그룹 공지사항 내용으로 조회
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByContent(String content);

}
