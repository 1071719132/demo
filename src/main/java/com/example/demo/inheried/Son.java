package com.example.demo.inheried;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Son extends Father {

    private String b;
}
