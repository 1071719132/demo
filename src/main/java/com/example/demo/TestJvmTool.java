package com.example.demo;

import java.sql.SQLOutput;

public class TestJvmTool {

    public static void main(String[] args) {

//        System.out.println("max_memory=" + Runtime.getRuntime().maxMemory() / (1024 * 1024) + "m");
//
//        System.out.println("total_memory=" + Runtime.getRuntime().totalMemory() / (1024 * 1024) + "m");
//
//        System.out.println("free_memory=" + Runtime.getRuntime().freeMemory() / (1024 * 1024) + "m");；d
//
//        System.out.println("available_processors=" + Runtime.getRuntime().availableProcessors());

        for (int i = 0;; i++) {
            System.out.println(new Double[1024 * 1024]);
        }
    }
}
