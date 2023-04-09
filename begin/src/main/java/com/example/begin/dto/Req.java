package com.example.begin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Req {
    private String name;
    private  int age;
    @JsonProperty(value = "phone_number")
    private String phoneNumber;
}
