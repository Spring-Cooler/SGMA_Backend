package com.springcooler.sgma.studygroupapplicant.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudyGroupApplicantDTO {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("application_status")
    private String applicationStatus;

    @JsonProperty("recruitment_board_id")
    private Long recruitmentBoardId;
    
}
