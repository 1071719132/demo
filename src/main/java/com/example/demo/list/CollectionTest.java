package com.example.demo.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionTest {

    public static void main(String[] args) {
        List<String> result = new ArrayList();

        System.out.println(result.stream().map(String::toString).collect(Collectors.toList()));

        System.out.println(result.stream().collect(Collectors.toMap(String::toString, String::chars)));
    }
}
