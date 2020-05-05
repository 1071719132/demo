package com.example.demo.service;

import com.example.demo.dto.AccentureResponseDto;
import com.example.demo.dto.Constant;
import com.example.demo.service.component.EnvResolver;
import com.example.demo.util.DateUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AccentureService {
    @Autowired
    private EnvResolver envResolver;

    private Map<String, Object> accentureParamMap = new HashMap();

    @PostConstruct
    private void init() {
        try {
            accentureParamMap = new Gson().fromJson(envResolver.getEnvConfig(Constant.ACCENTURE_REQUEST), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitContent() {
        List<String> days = DateUtil.getMonthDay("2020-03-01");

        for (String day : days) {
            submit(day);
        }
    }


    public void submit (String day) {
        try {
            log.info("==================================》preparing post day of:{}", day);

            accentureParamMap.put("updateTime", DateUtil.getCurrentDate());
            accentureParamMap.put("signDate", day);

            String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJzYW1hY2NvdW50X25hbWUiOiJkb25nLmNoZW5nIiwiZXhwIjoxNTgzNjgzMjAwfQ.nVJ4ESjlzYbmcUxwZiFilRdMQLmpr8oPO_nVvrONRbFbitpzC8-cN-C0HlHh-b9AJH4O1j5YBfueNNutSRGX9w";

            List<String> cookies = new ArrayList<>(16);
            cookies.add("groupAccess=[]");
            cookies.add("permission=false");
            cookies.add("token=" + accessToken);
            cookies.add("userInfo={%22eid%22:%22dong.cheng%22%2C%22sapId%22:%22%22}");

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.put(HttpHeaders.COOKIE, cookies);
            httpHeaders.add("Authorization", accessToken);

            HttpEntity<Map> httpEntity = new HttpEntity<>(accentureParamMap, httpHeaders);
            ResponseEntity<AccentureResponseDto> responseEntity = new RestTemplate()
                    .exchange(Constant.ACCENTURE_URL,
                            HttpMethod.POST,
                            httpEntity,
                            AccentureResponseDto.class);

            if (StringUtils.equals(responseEntity.getBody().getCode(), Constant.ACCENTURE_RESPONSE_SUCESS)) {
                log.info("===========================》post {} request to accenture success:{}", day, responseEntity);
            } else {
                log.error("post request {} to accenture occurs error:{}", day, responseEntity);
            }
        } catch (RestClientException e) {
            log.error("post request {} to accenture occurs exception:{}", day, e);

            try {
                Thread.sleep(20000);
                submit(day);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}