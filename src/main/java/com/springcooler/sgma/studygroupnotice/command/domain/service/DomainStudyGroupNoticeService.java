package com.springcooler.sgma.studygroupnotice.command.domain.service;

import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNoticeStatus;

public interface DomainStudyGroupNoticeService {

    boolean isActive(StudyGroupNoticeStatus activeStatus);

}
