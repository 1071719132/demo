package com.example.demo.task;

import com.example.demo.service.AccentureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor
@Slf4j
public class AccentureTask implements CommandLineRunner {
    private final AccentureService accentureService;

    @Override
    public void run(String... args) {
        log.info("start accenture request task......");
        accentureService.submitContent();
    }
}
