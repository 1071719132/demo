package com.example.demo.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        HttpEntity<byte[]> httpEntity = new HttpEntity<>(null, headers);

        String url = "https://www.echartsjs.com/examples/data/asset/data/gps/gps_209.bin";
        byte[] bytes = new RestTemplate()
                .exchange(url, HttpMethod.GET, httpEntity, byte[].class).getBody();
        System.out.println(bytes);

    }

    private static String convert(InputStream inputStream) {
        try {
            byte[] bytes = new byte[0];
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
