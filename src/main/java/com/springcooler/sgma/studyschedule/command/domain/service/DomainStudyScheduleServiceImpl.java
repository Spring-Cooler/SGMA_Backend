package com.springcooler.sgma.studyschedule.command.domain.service;

import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudyScheduleStatus;
import org.springframework.stereotype.Service;

@Service
public class DomainStudyScheduleServiceImpl implements DomainStudyScheduleService {

    @Override
    public boolean isActive(String activeStatus) {
        return activeStatus.equals(StudyScheduleStatus.ACTIVE.name());
    }

}
