package com.example.begin.dto;

import com.example.begin.entity.Books;
import com.example.begin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewDto {
    private String result;
    private Long idx;
    private String title;
    private String contents;
    private Long useridx;
    private String userId;
    private Long bookIdx;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
