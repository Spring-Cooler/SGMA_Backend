package com.springcooler.sgma.studygroupnotice.command.application.service;

import com.springcooler.sgma.studygroupnotice.command.application.dto.StudyGroupNoticeDTO;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.RestStatus;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;
import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNoticeStatus;
import com.springcooler.sgma.studygroupnotice.command.domain.repository.StudyGroupNoticeRepository;
import com.springcooler.sgma.studygroupnotice.command.domain.service.DomainStudyGroupNoticeService;
import com.springcooler.sgma.studygroupnotice.common.exception.CommonException;
import com.springcooler.sgma.studygroupnotice.common.exception.ErrorCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class AppStudyGroupNoticeServiceImpl implements AppStudyGroupNoticeService {

    private final ModelMapper modelMapper;
    private final DomainStudyGroupNoticeService domainStudyGroupNoticeService;
    private final StudyGroupNoticeRepository studyGroupNoticeRepository;

    @Autowired
    public AppStudyGroupNoticeServiceImpl(ModelMapper modelMapper,
                                          DomainStudyGroupNoticeService domainStudyGroupNoticeService,
                                          StudyGroupNoticeRepository studyGroupNoticeRepository) {
        this.modelMapper = modelMapper;
        this.domainStudyGroupNoticeService = domainStudyGroupNoticeService;
        this.studyGroupNoticeRepository = studyGroupNoticeRepository;
    }

    // 스터디그룹 공지사항 생성
    @Transactional
    @Override
    public StudyGroupNotice registStudyGroupNotice(StudyGroupNoticeDTO newNotice) {
        // DTO 유효성 검사
        if(!domainStudyGroupNoticeService.isValidDTO(RestStatus.POST, newNotice))
            throw new CommonException(ErrorCode.INVALID_REQUEST_BODY);

        // 생성 시각, 활성화 여부 초기화
        newNotice.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newNotice.setActiveStatus(StudyGroupNoticeStatus.ACTIVE);

        return studyGroupNoticeRepository.save(modelMapper.map(newNotice, StudyGroupNotice.class));
    }


    // 스터디그룹 공지사항 정보 수정
    @Transactional
    @Override
    public StudyGroupNotice modifyStudyGroupNotice(StudyGroupNoticeDTO modifyNotice) {
        // DTO 유효성 검사
        if(!domainStudyGroupNoticeService.isValidDTO(RestStatus.PUT, modifyNotice))
            throw new CommonException(ErrorCode.INVALID_REQUEST_BODY);

        // 기존 엔티티 조회
        StudyGroupNotice existingNotice =
                studyGroupNoticeRepository.findById(modifyNotice.getNoticeId())
                        .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_NOTICE));

        // 바뀐 제목, 내용, 수정 시각 업데이트
        existingNotice.setTitle(modifyNotice.getTitle());
        existingNotice.setContent(modifyNotice.getContent());
        existingNotice.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return studyGroupNoticeRepository.save(existingNotice);
    }

    // 스터디그룹 공지사항 삭제
    @Transactional
    @Override
    public void deleteStudyGroupNotice(Long noticeId) {
        // 기존 엔티티 조회
        StudyGroupNotice deleteNotice =
                studyGroupNoticeRepository.findById(noticeId)
                        .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_NOTICE));

        // 유효성 검사
        if(!domainStudyGroupNoticeService.isActive(deleteNotice.getActiveStatus()))
            throw new CommonException(ErrorCode.NOT_FOUND_STUDY_GROUP_NOTICE);

        // INACTIVE 처리
        deleteNotice.setActiveStatus(StudyGroupNoticeStatus.INACTIVE);
        studyGroupNoticeRepository.save(deleteNotice);
    }

}
