package com.springcooler.sgma.studyschedule.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.ScheduledFuture;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ScheduledTaskServiceTests {

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @Test
    void testUpdateScheduledTasks(){
        scheduledTaskService.updateScheduledTasks();

    }

    @Test
    public void testScheduleTaskAtTimestamp() throws InterruptedException {
        // Schedule a task 5 seconds into the future
        Instant futureInstant = Instant.now().plusSeconds(5);
        Timestamp timestamp = Timestamp.from(futureInstant);

        Runnable task = () -> log.info("Test Task Executed at: {}", Instant.now());

        log.info("Scheduling test task for: {}", timestamp);
        ScheduledFuture<?> future = scheduledTaskService.scheduleTaskAtTimestamp(timestamp, task);

        assertNotNull(future);
        assertFalse(future.isDone());

        // Wait for the task to execute (add a small buffer to ensure it has time to run)
        Thread.sleep(6000);

        assertTrue(future.isDone());
        log.info("Test task finished");
    }
}