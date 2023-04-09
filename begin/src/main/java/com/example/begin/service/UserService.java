package com.example.begin.service;

import com.example.begin.dto.UserDto;
import com.example.begin.entity.User;
import com.example.begin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private  final EntityManager entityManager;
    public UserDto findUserInfo(String userId) {
        var user = userRepository.findByUserId(userId);

        if(user.isPresent()){
            return entityToDto(user.get());
        }

        return new UserDto();
    }

    public UserDto registerUser(UserDto userDto){
        var user = userRepository.save(DtoToEntity(userDto));
        return entityToDto(user);
    }

    public UserDto entityToDto(User user) {
        var dto = UserDto.builder().userId(user.getUserId())
                .addr(user.getAddr())
                .userPw(user.getUserPw())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .idx(user.getIdx())
                .nick(user.getNick())
                .build();
        return dto;
    }

    public User DtoToEntity(UserDto dto) {
        var userDto = User.builder().userId(dto.getUserId())
                .addr(dto.getAddr())
                .userPw(dto.getUserPw())
                .idx(dto.getIdx())
                .nick(dto.getNick())
                .build();
        return userDto;
    }

    public List<UserDto> findAllUser(){
        var users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach(u ->{
            usersDto.add(entityToDto(u));
        });

        return usersDto;
    }

    public UserDto login(UserDto user){
        var loggedinUser = userRepository.findByUserId(user.getUserId());
        if(loggedinUser != null) {
            var loggedinuserDto = entityToDto(loggedinUser.get());
            log.info("trying login user : {}",loggedinuserDto.toString());
            if(loggedinuserDto.getUserPw().equals(user.getUserPw())) return loggedinuserDto;
            else return null;
        }

        else return null;

    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }


}
