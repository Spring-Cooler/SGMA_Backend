package com.springcooler.sgma.studygroupnotice.query.repository;

import com.springcooler.sgma.studygroupnotice.query.dto.StudyGroupNoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyGroupNoticeMapper {

    // 스터디그룹 공지사항 전체 조회(스터디그룹 아이디)
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByGroupId(@Param("groupId") Long groupId,
                                                             @Param("pageSize") Integer pageSize,
                                                             @Param("offset") Integer offset);

    // 스터디그룹 공지사항 단건 조회(공지사항 아이디)
    StudyGroupNoticeDTO findStudyGroupNoticeByNoticeId(Long noticeId);

    // 스터디그룹 공지사항 제목으로 조회
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByTitle(@Param("title") String title,
                                                           @Param("pageSize") Integer pageSize,
                                                           @Param("offset") Integer offset);

    // 스터디그룹 공지사항 내용으로 조회
    List<StudyGroupNoticeDTO> findStudyGroupNoticesByContent(@Param("content") String content,
                                                             @Param("pageSize") Integer pageSize,
                                                             @Param("offset") Integer offset);

    // 그룹명으로 전체 공지사항 개수 조회
    Integer getTotalElementsByGroupId(Long groupId);

    // 제목으로 전체 공지사항 개수 조회
    Integer getTotalElementsByTitle(String title);

    // 내용으로 전체 공지사항 개수 조회
    Integer getTotalElementsByContent(String content);

}
