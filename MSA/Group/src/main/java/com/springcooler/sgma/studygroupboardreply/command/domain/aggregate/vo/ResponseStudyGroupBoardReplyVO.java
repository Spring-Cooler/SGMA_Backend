package com.springcooler.sgma.studygroupboardreply.command.domain.aggregate.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseStudyGroupBoardReplyVO {

    @JsonProperty("reply_id")
    private Long studyGroupBoardReplyId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("member_id")
    private Long memberId;

    @JsonProperty("comment_id")
    private Long studyGroupBoardCommentId;

}
