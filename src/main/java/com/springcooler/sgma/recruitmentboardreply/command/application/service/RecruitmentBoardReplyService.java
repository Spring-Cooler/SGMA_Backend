package com.springcooler.sgma.recruitmentboardreply.command.application.service;

import com.springcooler.sgma.recruitmentboardreply.command.domain.aggregate.RecruitmentBoardReply;

public interface RecruitmentBoardReplyService {
    RecruitmentBoardReply createRecruitBoardReply(RecruitmentBoardReply recruitmentBoardReply);
}
