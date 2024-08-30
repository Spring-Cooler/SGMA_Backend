package com.springcooler.sgma.studygroupnotice.command.application.service;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNoticeStatus;
import com.springcooler.sgma.studygroupnotice.command.domain.repository.StudyGroupNoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class AppStudyGroupNoticeServiceImpl implements AppStudyGroupNoticeService {

    private final ModelMapper modelMapper;
    private final StudyGroupNoticeRepository studyGroupNoticeRepository;

    @Autowired
    public AppStudyGroupNoticeServiceImpl(ModelMapper modelMapper,
                                          StudyGroupNoticeRepository studyGroupNoticeRepository) {
        this.modelMapper = modelMapper;
        this.studyGroupNoticeRepository = studyGroupNoticeRepository;
    }

    // 스터디그룹 공지사항 생성
    @Transactional
    @Override
    public StudyGroupNotice registStudyGroupNotice(StudyGroupNoticeDTO newNotice) {
        // 생성 시각, 활성화 여부 초기화
        newNotice.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newNotice.setActiveStatus(StudyGroupNoticeStatus.ACTIVE.name());

        return studyGroupNoticeRepository.save(modelMapper.map(newNotice, StudyGroupNotice.class));
    }

    @Transactional
    @Override
    public StudyGroupNotice modifyStudyGroupNotice(StudyGroupNoticeDTO studyGroupNotice) {
        return null;
    }

    @Transactional
    @Override
    public void deleteStudyGroupNotice(StudyGroupNoticeDTO studyGroupNotice) {

    }
}
