package com.springcooler.sgma.recruitmentboardlike.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RecruitmentBoardLikeId.class)
public class RecruitmentBoardLike {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "recruitment_board_id")
    private Long recruitmentBoardId;
}
