package com.springcooler.sgma.studygroupnotice.command.application.service;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;

public interface AppStudyGroupNoticeService {

    StudyGroupNotice registStudyGroupNotice(StudyGroupNoticeDTO newNotice);

    StudyGroupNotice modifyStudyGroupNotice(StudyGroupNoticeDTO modifyNotice);

    void deleteStudyGroupNotice(Long noticeId);

}
