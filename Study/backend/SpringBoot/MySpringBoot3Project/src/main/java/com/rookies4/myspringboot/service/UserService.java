package com.rookies4.myspringboot.service;

import com.rookies4.myspringboot.controller.dto.UserDTO;
import com.rookies4.myspringboot.entity.UserEntity;
import com.rookies4.myspringboot.exception.BusinessException;
import com.rookies4.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDTO.UserResponse createUser(UserDTO.UserCreateRequest request){
        userRepository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new BusinessException("User with this email already exists", HttpStatus.CONFLICT);
                });
        //DTO를 Entity로 변환하여 저장
        UserEntity entity = request.toEntity();
        UserEntity savedEntity = userRepository.save(entity);
        return new UserDTO.UserResponse(savedEntity);
    }
    //Id로 User 조회
    public UserDTO.UserResponse getUserById(Long id) {

    }

    //내부 Helper Method
    private UserEntity getUserExist(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
    }
}
