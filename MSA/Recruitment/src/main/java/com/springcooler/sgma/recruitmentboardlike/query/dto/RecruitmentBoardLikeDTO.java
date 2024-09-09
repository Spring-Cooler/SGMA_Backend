package com.springcooler.sgma.recruitmentboardlike.query.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RecruitmentBoardLikeDTO {
    private Long userId;
    private Long recruitmentBoardId;
}
