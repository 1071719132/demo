package com.example.demo.service;

import com.example.demo.service.component.EnvResolver;
import com.example.demo.dto.Constant;
import com.example.demo.dto.FordResponseDto;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class FordService {
    @Autowired
    private EnvResolver envResolver;

    private Map<String, Object> fordParamMap = new HashMap();

    @PostConstruct
    private void init() {
        try {
            fordParamMap = new Gson().fromJson(envResolver.getEnvConfig(Constant.FORD_REQUEST), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitContent() {
        try {
            HttpEntity<Map> httpEntity = new HttpEntity<>(fordParamMap);
            ResponseEntity<FordResponseDto> responseEntity = new RestTemplate()
                    .exchange(Constant.FORD_URL,
                            HttpMethod.POST,
                            httpEntity,
                            FordResponseDto.class);

            if (StringUtils.equals(responseEntity.getBody().getStatus(), Constant.FORD_RESPONSE_SUCESS)) {
                log.info("===========================》post request to ford success:{}", responseEntity);
            } else {
                log.error("post request to ford occurs error:{}", responseEntity);
            }
        } catch (RestClientException e) {
            log.error("post request to ford occurs exception:{}", e.getMessage());
        }
    }
}
