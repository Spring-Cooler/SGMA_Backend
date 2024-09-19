package com.springcooler.sgma.studyschedule.scheduler;

import com.springcooler.sgma.studyschedule.command.domain.aggregate.StudySchedule;
import com.springcooler.sgma.studyschedule.command.domain.repository.StudyScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
@Slf4j
@Service
public class ScheduledTaskService {

    private final TaskScheduler taskScheduler;
    private static List<StudySchedule> scheduledTasks;
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
        Timestamp startTime = Timestamp.valueOf("2024-09-15 17:30:00");
        Timestamp endTime = Timestamp.valueOf("2024-09-15 18:30:00");
        List<StudySchedule> scheduledTasks = studyScheduleRepository.findByScheduleEndTimeBetween(startTime, endTime);
        scheduledTasks.forEach(scheduledTask -> {
            scheduleTaskAtTimestamp(scheduledTask.getScheduleEndTime(), ()->log.info(scheduledTask.getScheduleId().toString()));
        });
    }
//    TODO: 가져온 작업들을 taskScheduler에 등록
    public ScheduledFuture<?> scheduleTaskAtTimestamp(Timestamp timestamp, Runnable task) {
        Date date = new Date(timestamp.getTime());
        return taskScheduler.schedule(task, date);
    }

}
