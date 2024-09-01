package com.springcooler.sgma.user.command.application.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.springcooler.sgma.user.command.application.dto.RequestUpdateUserDTO;
import com.springcooler.sgma.user.command.domain.aggregate.vo.RequestUpdateUserVO;
import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;
import com.springcooler.sgma.user.command.domain.repository.UserRepository;
import com.springcooler.sgma.user.common.exception.CommonException;
import com.springcooler.sgma.user.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service("userCommandServiceImpl")
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final AmazonS3Client s3Client;
//
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;

//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, AmazonS3Client s3Client) {
//        this.userRepository = userRepository;
//        this.s3Client = s3Client;
//    }
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 사용자 계정을 비활성화하는 메서드.
     */
    @Override
    public UserEntity deactivateUser(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_USER);
        }
        UserEntity userEntity = user.get();
        userEntity.deactivateUser();  // 사용자 상태를 비활성화(INACTIVE)로 변경
        return userRepository.save(userEntity);  // 변경된 상태를 저장
    }

    /**
     * 사용자 계정을 활성화하는 메서드.
     */
    @Override
    public UserEntity activateUser(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new CommonException(ErrorCode.NOT_FOUND_USER);
        }
        UserEntity userEntity = user.get();
        userEntity.activateUser();  // 사용자 상태를 활성화(ACTIVE)로 변경
        return userRepository.save(userEntity);  // 변경된 상태를 저장
    }

    /**설명.
     *  사용자의 프로필(닉네임, 이미지)을 업데이트하는 메서드.
     *설명.
     * @param userId 프로필을 업데이트할 사용자의 ID
     * @param userUpdateDTO 업데이트할 정보가 담긴 DTO 객체
     * @return 업데이트된 UserEntity 객체
     * @throws CommonException 사용자가 존재하지 않을 경우 발생
     */
//    @Override
//    public UserEntity updateProfile(Long userId, RequestUpdateUserDTO userUpdateDTO) {
//        Optional<UserEntity> user = userRepository.findById(userId);
//        if (user.isEmpty()) {
//            throw new CommonException(ErrorCode.NOT_FOUND_USER);
//        }
//        UserEntity userEntity = user.get();
//
//        String imageUrl = null;
//
//        // 프로필 이미지가 제공된 경우에만 처리
//        if (userUpdateDTO.getProfileImage() != null && !userUpdateDTO.getProfileImage().isEmpty()) {
//            // 기존 이미지가 있으면 삭제
//            if (userEntity.getProfileImage() != null && !userEntity.getProfileImage().isEmpty()) {
//                deleteProfileImage(userEntity.getProfileImage());
//            }
//            // 새로운 이미지를 업로드하고 URL을 얻음
//            imageUrl = uploadProfileImage(userUpdateDTO.getProfileImage(), userId);
//        }
//
//        // 닉네임이나 이미지가 null일 수 있으므로 기존 값을 유지할지 여부를 확인
//        String updatedNickname = userUpdateDTO.getNickname() != null ? userUpdateDTO.getNickname() : userEntity.getNickname();
//        String updatedImageUrl = imageUrl != null ? imageUrl : userEntity.getProfileImage();
//
//        // 프로필 업데이트
//        userEntity.updateProfile(updatedNickname, updatedImageUrl);
//        return userRepository.save(userEntity);
//    }
//
//    /**설명.
//     *  S3에서 기존 프로필 이미지를 삭제하는 메서드.
//     *설명.
//     * @param fileUrl 삭제할 파일의 S3 URL
//     */
//    public void deleteProfileImage(String fileUrl) {
//        String splitStr = ".com/";
//        String fileName = fileUrl.substring(fileUrl.lastIndexOf(splitStr) + splitStr.length());
//
//        log.info("Attempting to delete file from S3: " + fileName);
//
//        try {
//            // S3에서 파일 삭제 요청
//            s3Client.deleteObject(new DeleteObjectRequest(bucket, fileName));
//            log.info("Successfully deleted image from S3: " + fileName);
//        } catch (AmazonClientException e) {
//            log.error("Failed to delete image from S3: " + fileName, e);
//        }
//    }
//
//    /**설명.
//     *  MultipartFile을 S3에 업로드하고, 업로드된 파일의 URL을 반환하는 메서드.
//     *설명.
//     * @param profileImage 업로드할 프로필 이미지 파일
//     * @param userId 사용자의 ID로 파일명을 지정
//     * @return 업로드된 파일의 S3 URL
//     * @throws CommonException 파일 업로드에 실패할 경우 발생
//     */
//    private String uploadProfileImage(MultipartFile profileImage, Long userId) {
//        String originalFileName = profileImage.getOriginalFilename();
//        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();  // 확장자를 소문자로 변환
//        String fileName = "user_" + userId + fileExtension;  // 사용자 ID를 기반으로 파일명 생성
//
//        File file = convertMultipartFileToFile(profileImage);
//
//        try {
//            // S3에 파일 업로드 및 퍼블릭 읽기 권한 설정
//            s3Client.putObject(new PutObjectRequest(bucket, fileName, file)
//                    .withCannedAcl(CannedAccessControlList.PublicRead));
//            return s3Client.getUrl(bucket, fileName).toString();
//        } catch (AmazonClientException e) {
//            log.error("S3에 이미지 업로드 실패", e);
//            throw new CommonException(ErrorCode.FILE_UPLOAD_ERROR);
//        } finally {
//            if (file.delete()) {
//                log.info("임시 파일 삭제 성공");
//            } else {
//                log.warn("임시 파일 삭제 실패");
//            }
//        }
//    }
//
//    /**설명.
//     *  MultipartFile을 File 객체로 변환하는 메서드.
//     *설명.
//     * @param file 변환할 MultipartFile 객체
//     * @return 변환된 File 객체
//     * @throws CommonException 파일 변환에 실패할 경우 발생
//     */
//    private File convertMultipartFileToFile(MultipartFile file) {
//        File convertedFile = new File(file.getOriginalFilename());
//        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
//            fos.write(file.getBytes());
//        } catch (IOException e) {
//            log.error("Error converting MultipartFile to File", e);
//            throw new CommonException(ErrorCode.FILE_CONVERSION_ERROR);
//        }
//        return convertedFile;
//    }
}
