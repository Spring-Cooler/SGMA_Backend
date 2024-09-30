package com.springcooler.sgma.studyschedule.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@SpringBootTest
@Slf4j
class ScheduledTaskServiceTests {
    @Autowired
    private ScheduledTaskService scheduledTaskService;
    @Autowired
    private TrackingThreadPoolTaskScheduler scheduler;

    @Test
    void testUpdateScheduledTasks() throws Exception{
        scheduledTaskService.updateScheduledTasks();
        List<ScheduledFuture<?>> scheduledTasks = scheduler.getScheduledTasks();
        log.info("now(): {}", new Timestamp(Instant.now().toEpochMilli()));
        Thread.sleep(1000 * 240);

    }
}