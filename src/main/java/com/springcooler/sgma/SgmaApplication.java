package com.springcooler.sgma;

import com.springcooler.sgma.studygroupapplicant.query.service.StudyGroupApplicantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgmaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SgmaApplication.class, args);
		StudyGroupApplicantService studyGroupApplicantService = new StudyGroupApplicantService();
		studyGroupApplicantService.studyGroupRecruitmentTest();
	}
}
