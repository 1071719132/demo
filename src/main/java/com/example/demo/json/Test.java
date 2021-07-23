package com.example.demo.json;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) {
        BeanA beanA = new BeanA();
        beanA.setId("1");
        beanA.setName("2");
        String jsonValue = JSONObject.toJSONString(beanA);
        System.out.println(jsonValue);


        BeanB beanB = null;
        try {
            beanB = new ObjectMapper().readValue(jsonValue, BeanB.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(beanB);


    }
}
