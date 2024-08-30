package com.springcooler.sgma.studygroupnotice.command.domain.service;

import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNoticeStatus;
import org.springframework.stereotype.Service;

@Service
public class DomainStudyGroupNoticeServiceImpl implements DomainStudyGroupNoticeService {

    @Override
    public boolean isActive(String activeStatus) {
        return activeStatus.equals(StudyGroupNoticeStatus.ACTIVE.name());
    }

}
