package com.springcooler.sgma.studygroupboard.command.application.service;

import com.springcooler.sgma.studygroupboard.command.application.dto.StudyGroupBoardDTO;

public interface AppStudyGroupBoardService {

    StudyGroupBoardDTO registStudyGroupBoard(StudyGroupBoardDTO newBoard);

    StudyGroupBoardDTO modifyStudyGroupBoard(StudyGroupBoardDTO modifyBoard);

    void deleteStudyGroupBoard(Long boardId);

}
