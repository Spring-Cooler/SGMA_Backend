package com.springcooler.sgma.studygroupboard.command.application.controller;

import com.springcooler.sgma.studygroupboard.command.application.dto.StudyGroupBoardDTO;
import com.springcooler.sgma.studygroupboard.command.application.service.AppStudyGroupBoardService;
import com.springcooler.sgma.studygroupboard.command.domain.aggregate.vo.RequestStudyGroupBoardVO;
import com.springcooler.sgma.studygroupboard.command.domain.aggregate.vo.ResponseStudyGroupBoardVO;
import com.springcooler.sgma.studygroupboard.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("commandStudyGroupBoardController")
@RequestMapping("/api/study-group/boards")
@Slf4j
public class StudyGroupBoardController {

    private final ModelMapper modelMapper;
    private final AppStudyGroupBoardService studyGroupBoardService;

    @Autowired
    public StudyGroupBoardController(ModelMapper modelMapper,
                                     AppStudyGroupBoardService studyGroupBoardService) {
        this.modelMapper = modelMapper;
        this.studyGroupBoardService = studyGroupBoardService;
    }

    @PostMapping
    public ResponseDTO<?> registStudyGroupBoard(@RequestBody RequestStudyGroupBoardVO newBoard) {
        StudyGroupBoardDTO board = modelMapper.map(newBoard, StudyGroupBoardDTO.class);
        board = studyGroupBoardService.registStudyGroupBoard(board);
        ResponseStudyGroupBoardVO res = modelMapper.map(board, ResponseStudyGroupBoardVO.class);
        return ResponseDTO.ok(res);
    }

    @PutMapping
    public ResponseDTO<?> modifyStudyGroupBoard(@RequestBody RequestStudyGroupBoardVO modifyBoard) {
        StudyGroupBoardDTO board = modelMapper.map(modifyBoard, StudyGroupBoardDTO.class);
        board = studyGroupBoardService.modifyStudyGroupBoard(board);
        ResponseStudyGroupBoardVO res = modelMapper.map(board, ResponseStudyGroupBoardVO.class);
        return ResponseDTO.ok(res);
    }

    @DeleteMapping("/{boardId}")
    public ResponseDTO<?> deleteStudyGroupBoard(@PathVariable("boardId") Long boardId) {
        studyGroupBoardService.deleteStudyGroupBoard(boardId);
        return ResponseDTO.ok(null);
    }

}
