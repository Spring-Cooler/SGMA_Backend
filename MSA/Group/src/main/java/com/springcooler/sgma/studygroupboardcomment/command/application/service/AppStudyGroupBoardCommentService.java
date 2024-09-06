package com.springcooler.sgma.studygroupboardcomment.command.application.service;

import com.springcooler.sgma.studygroupboardcomment.command.application.dto.StudyGroupBoardCommentDTO;

public interface AppStudyGroupBoardCommentService {

    StudyGroupBoardCommentDTO registStudyGroupBoardComment(StudyGroupBoardCommentDTO newComment);

    StudyGroupBoardCommentDTO modifyStudyGroupBoardComment(StudyGroupBoardCommentDTO modifyComment);

    void deleteStudyGroupBoardComment(Long commentId);

}
