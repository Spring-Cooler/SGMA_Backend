package com.springcooler.sgma.studyschedule.scheduler;

import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
@Slf4j
@Service
public class ScheduledTaskService {

    private final TaskScheduler taskScheduler;
    public List<StudySchedule> scheduledTasks;
    private final StudyScheduleRepository studyScheduleRepository;
    @Autowired
    public ScheduledTaskService(TaskScheduler taskScheduler, StudyScheduleRepository studyScheduleRepository) {
        this.taskScheduler = taskScheduler;
        this.studyScheduleRepository = studyScheduleRepository;
    }

//    TODO: 1시간 단위로 작업 가져옴
    @Scheduled(fixedRate = 3600000)
    public void updateScheduledTasks(){
//        @Scheduled는 매개변수 없는 method에만 사용이 가능해서 테스트용으로 startTime 작성
//        now()로 수정 예정
        Timestamp startTime = Timestamp.valueOf("2024-09-01 00:00:00");
//        DB의 스케쥴 목록을 읽어오기 위해 한달로 기간 설정
//        1시간 단위로 수정 예정
        Timestamp endTime = Timestamp.valueOf(startTime.toLocalDateTime().plusMonths(1));

        List<StudySchedule> scheduledTasks = studyScheduleRepository.findByScheduleEndTimeBetween(startTime, endTime);
        scheduledTasks.forEach(scheduledTask -> {
//            TODO: scheduleTaskAtTimestamp
            log.info("scheduledTask: {}", scheduledTask);


        });
    }
//    TODO: 가져온 작업들을 taskScheduler에 등록
    public ScheduledFuture<?> scheduleTaskAtTimestamp(Timestamp timestamp, Runnable task) {
        Instant date = Instant.from((TemporalAccessor) timestamp).plusSeconds(5);
        return taskScheduler.schedule(task, date);
    }

}
