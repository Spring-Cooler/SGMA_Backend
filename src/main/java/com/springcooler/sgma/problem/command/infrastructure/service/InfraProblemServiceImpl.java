package com.springcooler.sgma.problem.command.infrastructure.service;

import com.springcooler.sgma.choice.command.application.service.AppChoiceService;
import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;
import com.springcooler.sgma.problem.command.domain.aggregate.vo.ScheduleParticipantVO;
import com.springcooler.sgma.problem.command.domain.aggregate.vo.ScheduleVO;
import com.springcooler.sgma.studyschedule.query.dto.StudyScheduleDTO;
import com.springcooler.sgma.studyschedule.query.service.StudyScheduleService;
import com.springcooler.sgma.studyscheduleparticipant.query.dto.StudyScheduleParticipantDTO;
import com.springcooler.sgma.studyscheduleparticipant.query.service.StudyScheduleParticipantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InfraProblemServiceImpl implements InfraProblemService {

    private final AppChoiceService appChoiceService;
    private final StudyScheduleService studyScheduleService;
    private final StudyScheduleParticipantService studyScheduleParticipantService;

    @Autowired
    public InfraProblemServiceImpl(AppChoiceService appChoiceService
    , StudyScheduleService studyScheduleService
    , StudyScheduleParticipantService studyScheduleParticipantService) {
        this.appChoiceService = appChoiceService;
        this.studyScheduleService = studyScheduleService;
        this.studyScheduleParticipantService = studyScheduleParticipantService;
    }

    @Transactional
    @Override
    public int requestRegistChoices(long problemId, String[] choices) {
        return appChoiceService.registChoices(new ProblemVO(problemId, choices));
    }


    @Override
    public ScheduleVO requestScheduleInfo(long scheduleId) {
        StudyScheduleDTO scheduleDTO = studyScheduleService.findStudyScheduleByScheduleId(scheduleId);
        ScheduleVO scheduleVO = new ScheduleVO(scheduleDTO.getScheduleId(), scheduleDTO.getScheduleStartTime(), scheduleDTO.getScheduleEndTime());
        return scheduleVO;
    }

    @Override
    public ScheduleParticipantVO requestScheduleParticipant(long scheduleId) {
        List<StudyScheduleParticipantDTO> participants = studyScheduleParticipantService.findStudyScheduleParticipant(scheduleId);
        ScheduleParticipantVO scheduleParticipantVO = new ScheduleParticipantVO();
        scheduleParticipantVO.setScheduleId(scheduleId);
        Map<Long, Long> participantMap = new HashMap<>();
        participants.stream().forEach(x->participantMap.put(x.getParticipantId(), x.getMemberId()));
        scheduleParticipantVO.setParticipants(participantMap);
        return scheduleParticipantVO;
        //        return studyScheduleService.findStudyScheduleByScheduleId(scheduleId);
    }
}
