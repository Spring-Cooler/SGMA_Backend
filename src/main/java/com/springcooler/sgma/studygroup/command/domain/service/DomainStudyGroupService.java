package com.springcooler.sgma.studygroup.command.domain.service;

import org.springframework.stereotype.Service;

@Service
public class DomainStudyGroupService {

    public boolean isActive(String groupStatus) {
        return groupStatus.equals("ACTIVE");
    }

}
