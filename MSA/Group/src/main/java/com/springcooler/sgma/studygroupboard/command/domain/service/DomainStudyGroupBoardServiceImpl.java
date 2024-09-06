package com.springcooler.sgma.studygroupboard.command.domain.service;

import com.springcooler.sgma.studygroupboard.command.application.dto.StudyGroupBoardDTO;
import com.springcooler.sgma.studygroupboard.command.domain.aggregate.RestStatus;
import com.springcooler.sgma.studygroupboard.command.domain.aggregate.StudyGroupBoardStatus;
import org.springframework.stereotype.Service;

@Service
public class DomainStudyGroupBoardServiceImpl implements DomainStudyGroupBoardService{

    @Override
    public boolean isValidDTO(RestStatus restStatus, StudyGroupBoardDTO studyGroupboardDTO) {
        if(studyGroupboardDTO == null) return false;
        switch (restStatus) {
            case POST:
                if(studyGroupboardDTO.getTitle() == null ||
                        studyGroupboardDTO.getContent() == null ||
                        studyGroupboardDTO.getMemberId() == null ||
                        studyGroupboardDTO.getGroupId() == null) return false;
                break;
            case PUT:
                if(studyGroupboardDTO.getStudyGroupBoardId() == null ||
                        studyGroupboardDTO.getTitle() == null ||
                        studyGroupboardDTO.getContent() == null) return false;
                break;
        }

        return true;
    }

    @Override
    public boolean isActive(StudyGroupBoardStatus activeStatus) {
        return activeStatus.equals(StudyGroupBoardStatus.ACTIVE);
    }

}
