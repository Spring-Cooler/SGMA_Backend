package com.springcooler.sgma.choice.command.application.controller;

import com.springcooler.sgma.choice.command.application.service.AppChoiceService;
import com.springcooler.sgma.problem.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/problem-choices")
public class ChoiceController {
    private final AppChoiceService appChoiceService;

    @Autowired
    public ChoiceController(AppChoiceService appChoiceService) {
        this.appChoiceService = appChoiceService;
    }

}
