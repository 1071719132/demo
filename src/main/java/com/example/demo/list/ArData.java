package com.example.demo.list;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArData {

    private static List<RmData> rms = new ArrayList<>(2);

    public static void main(String[] args) {
        rms.add(new RmData("1", null));
        rms.add(new RmData("2", null));
        System.out.println(rms);

        for (RmData item : rms) {
            item.setName(item.getName() + "qq");
            item.setData(new Detail("7777"));
        }


        System.out.println(rms);
    }

    @AllArgsConstructor
    @Data
    public static class RmData {

        private String name;
        private Detail data;
    }

    @AllArgsConstructor
    @Data
    public static class Detail {
        private String name;
    }

}
