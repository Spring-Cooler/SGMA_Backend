package com.springcooler.sgma.studyscheduleparticipant.command.infrastructure.service;

import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.repository.StudyScheduleParticipantRepository;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyschedule.common.exception.CommonException;
import com.springcooler.sgma.studyschedule.common.exception.ErrorCode;
import com.springcooler.sgma.submittedanswer.command.domain.repository.SubmittedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfraStudyScheduleParticipantServiceImpl implements InfraStudyScheduleParticipantService {

    private final StudyScheduleParticipantRepository participantRepository;
    private final StudyScheduleRepository scheduleRepository;
    private final SubmittedAnswerRepository answerRepository;

    @Autowired
    public InfraStudyScheduleParticipantServiceImpl(StudyScheduleParticipantRepository participantRepository,
                                                    StudyScheduleRepository scheduleRepository,
                                                    SubmittedAnswerRepository answerRepository) {
        this.participantRepository = participantRepository;
        this.scheduleRepository = scheduleRepository;
        this.answerRepository = answerRepository;
    }

    @Transactional
    @Override
    public void increaseNumSubmittedProblems(Long scheduleId, Long participantId) {
        StudyScheduleParticipant participant = participantRepository.findByScheduleIdAndParticipantId(scheduleId, participantId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_SCHEDULE_PARTICIPANT));

        // 1. 제출 문제 수 증가
        participant.setNumSubmittedProblems(participant.getNumSubmittedProblems() + 1);
        participantRepository.save(participant);

        // 2. 제출 상태 확인 및 업데이트 (제출한 문제 수가 일정에서 요구하는 문제 수와 같거나 많을 때)
        StudySchedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_SCHEDULE));

        if (participant.getNumSubmittedProblems() >= schedule.getNumProblemsPerParticipant()) {
            participant.setSubmissionStatus("Y");
            participantRepository.save(participant);
        }
    }

    @Transactional
    @Override
    public void decreaseNumSubmittedProblems(Long scheduleId, Long participantId) {
        StudyScheduleParticipant participant = participantRepository.findByScheduleIdAndParticipantId(scheduleId, participantId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_SCHEDULE_PARTICIPANT));

        // 1. 제출 문제 수 감소 (최소값은 0)
        participant.setNumSubmittedProblems(Math.max(0, participant.getNumSubmittedProblems() - 1));
        participantRepository.save(participant);

        // 2. 제출 상태 확인 및 업데이트 (제출한 문제 수가 일정에서 요구하는 문제 수보다 적을 때 'N'으로 변경)
        StudySchedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_SCHEDULE));

        if (participant.getNumSubmittedProblems() < schedule.getNumProblemsPerParticipant()) {
            participant.setSubmissionStatus("N");
            participantRepository.save(participant);
        }
    }

//    @Transactional
//    @Override
//    public double gradeAndUpdateParticipantScore(long scheduleId, long participantId) {
//        // 1. 참가자의 답안 채점
//        double score = appStudyScheduleParticipantService.gradeSubmittedAnswersByParticipantId(scheduleId, participantId);
//
//        // 2. 채점 결과를 해당 참가자에 업데이트
//        StudyScheduleParticipant participant = participantRepository.findByScheduleIdAndParticipantId(scheduleId, participantId)
//                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_SCHEDULE_PARTICIPANT));
//
//        participant.setTestScore(score);
//        participant.setTestPercentage(score * 100);
//
//        participantRepository.save(participant);
//
//        return score;
//    }
}
