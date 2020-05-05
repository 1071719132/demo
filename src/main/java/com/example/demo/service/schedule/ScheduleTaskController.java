package com.example.demo.service.schedule;

import com.example.demo.service.AccentureService;
import com.example.demo.service.FordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Slf4j
@AllArgsConstructor
@Controller
public class ScheduleTaskController {
	private final AccentureService accentureService;
	private final FordService fordService;

	@Scheduled(cron = "0 0 10,13,16 * * ?")
	public void task() {

		log.info("start ford submit task...");
		fordService.submitContent();

//		log.info("start accenture submit task...");
//		accentureService.submitContent();
	}
}