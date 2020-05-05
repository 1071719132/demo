package com.example.demo.task;

import com.example.demo.service.FordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class FordTask implements CommandLineRunner {
    private final FordService fordService;

    @Override
    public void run(String... args) {
        log.info("start ford request task......");
        fordService.submitContent();
    }
}
