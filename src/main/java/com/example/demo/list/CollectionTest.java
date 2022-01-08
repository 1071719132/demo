package com.example.demo.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTest {

    public static void main(String[] args) {

        Map<String, String> map1 = new HashMap<>(2);
        map1.put("1", "1");
        map1.put("2", "2");

        Map<String, String> map2 = new HashMap<>(2);
        map2.put("1", "11");

        Map result = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entity -> entity.getValue() + "<<<<",
                        (value1, value2) -> value2));
        System.out.println(result);

        map1.forEach((key, value) -> map2.merge(key, value, (v1, v2) -> v1));

        System.out.println(map1);

        System.out.println(map2);

//        List<String> result = new ArrayList();
//
//        System.out.println(result.stream().map(String::toString).collect(Collectors.toList()));
//
//        System.out.println(result.stream().collect(Collectors.toMap(String::toString, String::chars)));
    }
}
