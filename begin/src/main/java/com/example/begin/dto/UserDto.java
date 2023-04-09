package com.example.begin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private String result;

    private Long idx;
    private String userId;
    private String userPw;
    private String nick;
    private String addr;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
