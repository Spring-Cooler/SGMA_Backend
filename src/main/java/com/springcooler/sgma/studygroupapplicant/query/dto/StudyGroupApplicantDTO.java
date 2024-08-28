package com.springcooler.sgma.studygroupapplicant.query.dto;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class StudyGroupApplicantDTO {
    private Long recruitmentBoardId;
    private String title;
    private Timestamp createdAt;
    private Timestamp recruitmentStartTime;
    private Timestamp recruitmentEndTime;
    private String activeStatus;
    private int likes;
    private Long groupId;
    private int studyGroupCategoryId;

    public StudyGroupApplicantDTO() {
    }

    public StudyGroupApplicantDTO(Long recruitmentBoardId, String title, Timestamp createdAt, Timestamp recruitmentStartTime, Timestamp recruitmentEndTime, String activeStatus, int likes, Long groupId, int studyGroupCategoryId) {
        this.recruitmentBoardId = recruitmentBoardId;
        this.title = title;
        this.createdAt = createdAt;
        this.recruitmentStartTime = recruitmentStartTime;
        this.recruitmentEndTime = recruitmentEndTime;
        this.activeStatus = activeStatus;
        this.likes = likes;
        this.groupId = groupId;
        this.studyGroupCategoryId = studyGroupCategoryId;
    }

    public Long getRecruitmentBoardId() {
        return recruitmentBoardId;
    }

    public void setRecruitmentBoardId(Long recruitmentBoardId) {
        this.recruitmentBoardId = recruitmentBoardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getRecruitmentStartTime() {
        return recruitmentStartTime;
    }

    public void setRecruitmentStartTime(Timestamp recruitmentStartTime) {
        this.recruitmentStartTime = recruitmentStartTime;
    }

    public Timestamp getRecruitmentEndTime() {
        return recruitmentEndTime;
    }

    public void setRecruitmentEndTime(Timestamp recruitmentEndTime) {
        this.recruitmentEndTime = recruitmentEndTime;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public int getStudyGroupCategoryId() {
        return studyGroupCategoryId;
    }

    public void setStudyGroupCategoryId(int studyGroupCategoryId) {
        this.studyGroupCategoryId = studyGroupCategoryId;
    }

    @Override
    public String toString() {
        return "StudyGroupApplicantDTO{" +
                "recruitmentBoardId=" + recruitmentBoardId +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", recruitmentStartTime=" + recruitmentStartTime +
                ", recruitmentEndTime=" + recruitmentEndTime +
                ", activeStatus='" + activeStatus + '\'' +
                ", likes=" + likes +
                ", groupId=" + groupId +
                ", studyGroupCategoryId=" + studyGroupCategoryId +
                '}';
    }
}