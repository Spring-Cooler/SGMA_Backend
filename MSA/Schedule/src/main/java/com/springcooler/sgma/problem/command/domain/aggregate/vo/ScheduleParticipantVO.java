package com.springcooler.sgma.problem.command.domain.aggregate.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleParticipantVO {
    @JsonProperty("schedule_id")
    private long scheduleId;

    @JsonProperty("participants")
    private Map<Long, Long> participants;
}
