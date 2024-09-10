package com.springcooler.sgma.openai.controller;

import com.springcooler.sgma.openai.dto.RequestChatDTO;
import com.springcooler.sgma.openai.dto.ResponseChatDTO;
import com.springcooler.sgma.openai.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/bot")
public class OpenAIController {

    private final OpenAIService openAIService;

    @Autowired
    public OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("/grade")
    public String chat(@RequestParam(name = "answer") String answer,
                       @RequestParam(name = "submitted-answer") String submittedAnswer) {
        String prompt = answer + "가 정답이고" + submittedAnswer +
                "가 제출답안인데 정답여부에 대해 O또는 X로만 대답해줘";
        ResponseChatDTO res = openAIService.getGrade(prompt);
        return res.getChoices().get(0).getMessage().getContent();
    }

}
