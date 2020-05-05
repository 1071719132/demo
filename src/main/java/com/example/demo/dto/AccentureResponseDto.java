package com.example.demo.dto;

import lombok.Data;

@Data
public class AccentureResponseDto {
    private String message;
    private String code;
    private String status;
    private String data;
    private String messageList;
    private String defaultTarget;
}
