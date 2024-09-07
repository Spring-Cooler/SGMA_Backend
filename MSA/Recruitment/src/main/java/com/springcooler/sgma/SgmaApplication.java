package com.springcooler.sgma;


import com.springcooler.sgma.recruitmentboardcomment.command.domain.aggregate.RecruitmentBoardComment;
import com.springcooler.sgma.recruitmentboardlike.query.service.RecruitmentBoardLikeService;
import com.springcooler.sgma.recruitmentboardreply.query.service.RecruitmentBoardReplyService;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.springcooler.sgma.studygroupapplicant.command.infrastructure.service")
public class SgmaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SgmaApplication.class, args);
	}

}
