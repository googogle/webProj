package com.market.proj.marketProj.dto;

import com.market.proj.marketProj.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private Long idx;
    private Long userId;
    private String userEmail;
    private String userNickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserDTO EntityTODto(User userEntity){
        UserDTO userDto = UserDTO.builder().idx(userEntity.getIdx())
                .userId(userEntity.getUserId())
                .userEmail(userEntity.getUserEmail())
                .userNickname(userEntity.getUserNickname())
                .build();
        return userDto;
    }

    public static User DtoToEntity(UserDTO userDto){
        User userEntity = User.builder()
              .idx(userDto.getIdx())
                .userId(userDto.getUserId())
              .userEmail(userDto.getUserEmail())
              .userNickname(userDto.getUserNickname())
              .build();
        return userEntity;
    }
}
