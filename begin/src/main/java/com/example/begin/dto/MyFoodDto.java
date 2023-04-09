package com.example.begin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MyFoodDto {
    private Long idx;
    private String title;
    private String category;
    private String roadAddr;

}
