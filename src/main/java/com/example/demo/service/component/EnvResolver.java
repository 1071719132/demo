package com.example.demo.service.component;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class EnvResolver {
    private ResourceLoader resourceLoader;
    public EnvResolver(){
        resourceLoader = new DefaultResourceLoader();
    }

    public String getEnvConfig(String resourceName) throws Exception {
        InputStream inputStream = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:" + resourceName);
            inputStream = resource.getInputStream();

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);

            return new String(bytes);

        } finally {
            inputStream.close();
        }
    }
}