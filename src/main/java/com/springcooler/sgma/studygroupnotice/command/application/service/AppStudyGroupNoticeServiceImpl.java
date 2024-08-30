package com.springcooler.sgma.studygroupnotice.command.application.service;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNoticeStatus;
import com.springcooler.sgma.studygroupnotice.command.domain.repository.StudyGroupNoticeRepository;
import jakarta.persistence.EntityNotFoundException;
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


    // 스터디그룹 공지사항 정보 수정
    @Transactional
    @Override
    public StudyGroupNotice modifyStudyGroupNotice(StudyGroupNoticeDTO modifyNotice) {
        // 기존 엔티티 조회
        StudyGroupNotice existingNotice =
                studyGroupNoticeRepository.findById(modifyNotice.getNoticeId())
                        .orElseThrow(() -> new EntityNotFoundException("잘못된 수정 요청입니다."));

        // 바뀐 제목, 내용, 수정 시각 업데이트
        existingNotice.setTitle(modifyNotice.getTitle());
        existingNotice.setContent(modifyNotice.getContent());
        existingNotice.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return studyGroupNoticeRepository.save(existingNotice);
    }

    @Transactional
    @Override
    public void deleteStudyGroupNotice(StudyGroupNoticeDTO studyGroupNotice) {

    }
}
