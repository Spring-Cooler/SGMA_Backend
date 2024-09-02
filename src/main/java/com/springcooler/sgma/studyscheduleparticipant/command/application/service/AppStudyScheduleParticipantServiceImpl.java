package com.springcooler.sgma.studyscheduleparticipant.command.application.service;

import com.springcooler.sgma.problem.query.dto.ProblemDTO;
import com.springcooler.sgma.problem.query.service.ProblemService;
import com.springcooler.sgma.studyscheduleparticipant.command.application.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.submittedanswer.query.dto.SubmittedAnswerDTO;
import com.springcooler.sgma.submittedanswer.query.service.SubmittedAnswerService;
import com.springcooler.sgma.problem.query.common.ResponseMessage;
import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.aggregate.StudyScheduleParticipant;
import com.springcooler.sgma.studyscheduleparticipant.command.domain.repository.StudyScheduleParticipantRepository;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppStudyScheduleParticipantServiceImpl implements AppStudyScheduleParticipantService {

    private final StudyScheduleParticipantRepository participantRepository;
    private final StudyScheduleRepository scheduleRepository;
    private final ProblemService problemService;
    private final SubmittedAnswerService submittedAnswerService;
    private final ModelMapper modelMapper;

    @Autowired
    public AppStudyScheduleParticipantServiceImpl(StudyScheduleParticipantRepository participantRepository,
                                                  StudyScheduleRepository scheduleRepository,
                                                  ProblemService problemService,
                                                  SubmittedAnswerService submittedAnswerService,
                                                  ModelMapper modelMapper) {
        this.participantRepository = participantRepository;
        this.scheduleRepository = scheduleRepository;
        this.problemService = problemService;
        this.submittedAnswerService = submittedAnswerService;
        this.modelMapper = modelMapper;
    }

    // 스터디 그룹 일정 참가
    @Transactional
    @Override
    public StudySchedule registStudyScheduleParticipant(StudyScheduleParticipantDTO newParticipant) {
        if (newParticipant.getSubmissionStatus() == null) {
            newParticipant.setSubmissionStatus("N");
        }
        if (newParticipant.getNumSubmittedProblems() == null) {
            newParticipant.setNumSubmittedProblems(0);
        }
        if (newParticipant.getTestScore() == null) {
            newParticipant.setTestScore(0.0);
        }
        if (newParticipant.getTestPercentage() == null) {
            newParticipant.setTestPercentage(0.0);
        }

        StudySchedule schedule = scheduleRepository.findById(newParticipant.getScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일정 ID입니다."));

        // 중복 참가자 여부 확인
        if (participantRepository.existsByScheduleIdAndMemberId(newParticipant.getScheduleId(), newParticipant.getMemberId())) {
            throw new IllegalArgumentException("이미 해당 일정에 참가자로 등록되어 있습니다.");
        }

        StudyScheduleParticipant participant = modelMapper.map(newParticipant, StudyScheduleParticipant.class);
        participantRepository.save(participant);

        schedule.setNumParticipants(schedule.getNumParticipants() + 1);
        return scheduleRepository.save(schedule);
    }

    // 스터디 그룹 일정 참가 취소
    @Transactional
    @Override
    public void deleteStudyScheduleParticipant(Long scheduleId, Long memberId) {
        StudySchedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일정 ID입니다."));

        StudyScheduleParticipant participant = participantRepository
                .findByScheduleIdAndMemberId(scheduleId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("참가자가 이 일정에 등록되어 있지 않습니다."));

        participantRepository.delete(participant);

        schedule.setNumParticipants(schedule.getNumParticipants() - 1);
        scheduleRepository.save(schedule);
    }

    // 스터디 그룹 참가자 수정 - 출제 문제 수 업데이트
//    @Transactional
//    @Override
//    public ResponseMessage updateParticipantProblemCount(Long scheduleId, Long memberId) {
//        List<ProblemDTO> problems = problemService.findProblemsByScheduleIdAndParticipantId(scheduleId, memberId);
//
//        long numProblems = problems.stream()
//                .filter(problem -> problem.getScheduleId() == scheduleId && problem.getParticipantId() == memberId)
//                .count();
//
//        StudyScheduleParticipant participant = participantRepository
//                .findByScheduleIdAndMemberId(scheduleId, memberId)
//                .orElseThrow(() -> new IllegalArgumentException("참가자가 이 일정에 등록되어 있지 않습니다."));
//
//        participant.setNumSubmittedProblems((int) numProblems);
//        participantRepository.save(participant);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("participantId", memberId);
//        responseMap.put("numSubmittedProblems", numProblems);
//
//        StudySchedule schedule = scheduleRepository.findById(scheduleId)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일정 ID입니다."));
//
//        if (numProblems == schedule.getNumProblemsPerParticipant()) {
//            participant.setSubmissionStatus("Y");
//            participantRepository.save(participant);
//            responseMap.put("submissionStatus", "Y");
//        } else {
//            participant.setSubmissionStatus("N");
//            participantRepository.save(participant);
//            responseMap.put("submissionStatus", "N");
//        }
//
//        return new ResponseMessage(200, "참가자의 출제 문제 수가 성공적으로 업데이트되었습니다.", responseMap);
//    }

    // 특정 참가자의 시험 점수와 백분율 계산
//    @Transactional
//    @Override
//    public Map<String, Double> calculateParticipantScore(Long scheduleId, Long memberId) {
//        List<SubmittedAnswerDTO> submittedAnswers = submittedAnswerService.findSubmittedAnswersByProblemId(scheduleId);
//
//        long correctAnswersCount = submittedAnswers.stream()
//                .filter(answer -> "correct".equalsIgnoreCase(answer.getAnswerStatus()))
//                .count();
//
//        int totalQuestions = submittedAnswers.size();
//        int maxScore = 100;
//
//        double score = (double) correctAnswersCount / totalQuestions * maxScore;
//        double percentage = (correctAnswersCount / (double) totalQuestions) * 100.0;
//
//        StudyScheduleParticipant participant = participantRepository
//                .findByScheduleIdAndMemberId(scheduleId, memberId)
//                .orElseThrow(() -> new IllegalArgumentException("참가자가 이 일정에 등록되어 있지 않습니다."));
//
//        participant.setTestScore(score);
//        participant.setTestPercentage(percentage);
//        participantRepository.save(participant);
//
//        Map<String, Double> scoreData = new HashMap<>();
//        scoreData.put("score", score);
//        scoreData.put("percentage", percentage);
//
//        return scoreData;
//    }
}
