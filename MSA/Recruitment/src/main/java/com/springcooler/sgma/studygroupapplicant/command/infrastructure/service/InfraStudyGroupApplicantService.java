package com.springcooler.sgma.studygroupapplicant.command.infrastructure.service;

import com.springcooler.sgma.studygroupapplicant.command.domain.aggregate.vo.RequestStudyGroupMemberVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="study-group-service", url="localhost:8080")
public interface InfraStudyGroupApplicantService {

    @PostMapping("/study-group-service/api/study-groups/member")
    void registAcceptedMember(RequestStudyGroupMemberVO newMember);

}
