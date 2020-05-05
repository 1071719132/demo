package com.example.demo.dto;


import lombok.Data;

@Data
public class FordResponseDto {
    private String status;
    private String statusDesc;
    private String httpCode;
}
