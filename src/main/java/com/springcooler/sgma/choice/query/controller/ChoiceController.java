package com.springcooler.sgma.choice.query.controller;

import com.springcooler.sgma.choice.common.ResponseDTO;
import com.springcooler.sgma.choice.query.dto.ChoiceDTO;
import com.springcooler.sgma.choice.query.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("queryChoiceController")
@RequestMapping("/api/problem-choices")
public class ChoiceController {
    private final ChoiceService choiceService;

    @Autowired
    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping("/problem-choices/{problemChoiceId}")
    public ResponseDTO<ChoiceDTO> getChoiceById(@PathVariable long problemChoiceId){
        ChoiceDTO choiceDTO = choiceService.getChoiceById(problemChoiceId);
        return ResponseDTO.ok(choiceDTO);
    }
}
