package com.springcooler.sgma.problem.command.domain.aggregate.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleVO {

    @JsonProperty("schedule_id")
    private long scheduleId;

    @JsonProperty("schedule_start_time")
    private Timestamp scheduleStartTime;

    @JsonProperty("schedule_end_time")
    private Timestamp scheduleEndTime;
}
