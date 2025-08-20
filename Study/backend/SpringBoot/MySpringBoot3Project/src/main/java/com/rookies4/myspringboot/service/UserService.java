package com.rookies4.myspringboot.service;

import com.rookies4.myspringboot.controller.dto.UserDTO;
import com.rookies4.myspringboot.entity.UserEntity;
import com.rookies4.myspringboot.exception.BusinessException;
import com.rookies4.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

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
        UserEntity userEntity = getUserExist(id);
        return new UserDTO.UserResponse(userEntity);
    }

    //User 목록 조회하기
    public List<UserDTO.UserResponse> getAllUsers() {
        //List<UserEntity> -> List<UserDTO.UserResponse>
        //level1
//        return userRepository.findAll() //List<UserEntity>
//                .stream()//Stream<UserEntity>
//                .map(entity -> new UserDTO.UserResponse(entity))//Stream<UserDTO.UserResponse>
//                .collect(Collectors.toList());
        //level2
        return userRepository.findAll()
                .stream()
                .map(UserDTO.UserResponse::new)
                .toList();
    }

    //내부 Helper Method
    private UserEntity getUserExist(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
    }
}
