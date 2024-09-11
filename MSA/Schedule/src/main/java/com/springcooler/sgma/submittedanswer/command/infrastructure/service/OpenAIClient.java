package com.springcooler.sgma.submittedanswer.command.infrastructure.service;

import com.springcooler.sgma.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="sgma-ai-service", url="localhost:8080", configuration = FeignClientConfig.class )
public interface OpenAIClient {
    @GetMapping("/sgma-ai-service/api/bot/grade")
    String requestGradeEssayTypeProblem(String problem, String answer, String submittedAnswer);

}
