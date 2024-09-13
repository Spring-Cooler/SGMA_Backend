package com.springcooler.sgma.studygroupboard.query.repository;

import com.springcooler.sgma.studygroupboard.query.dto.StudyGroupBoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyGroupBoardMapper {

    // 게시글 그룹별 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByGroupId(@Param("groupId") Long groupId,
                                                           @Param("pageSize") Integer pageSize,
                                                           @Param("offset") Integer offset);

    // 게시글 그룹원별 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByMemberId(@Param("memberId") Long memberId,
                                                            @Param("pageSize") Integer pageSize,
                                                            @Param("offset") Integer offset);

    // 게시글 제목으로 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByTitle(@Param("title") String title,
                                                         @Param("pageSize") Integer pageSize,
                                                         @Param("offset") Integer offset);

    // 게시글 내용으로 조회
    List<StudyGroupBoardDTO> findStudyGroupBoardsByContent(@Param("content") String content,
                                                           @Param("pageSize") Integer pageSize,
                                                           @Param("offset") Integer offset);

    // 게시글 단건 조회
    StudyGroupBoardDTO findStudyGroupBoardByBoardId(Long boardId);

    // 그룹별 게시글 전체 개수 조회
    Integer getTotalElementsByGroupId(Long groupId);

    // 그룹원별 게시글 전체 개수 조회
    Integer getTotalElementsByMemberId(Long memberId);

    // 제목별 게시글 전체 개수 조회
    Integer getTotalElementsByTitle(String title);

    // 내용별 게시글 전체 개수 조회
    Integer getTotalElementsByContent(String content);

}
