package com.springcooler.sgma.submittedanswer.command.domain.repository;

import com.springcooler.sgma.submittedanswer.command.application.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswer;
import com.springcooler.sgma.submittedanswer.command.domain.aggregate.SubmittedAnswerPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SubmittedAnswerRepository extends JpaRepository<SubmittedAnswer, SubmittedAnswerPK> {
    List<SubmittedAnswer> findByParticipantId(Long participantId);

    // 특정 참가자의 정답 상태가 "RIGHT"인 답안의 개수를 조회하는 메서드
//    long countByParticipantIdAndAnswerStatus(Long participantId, String answerStatus);
}
