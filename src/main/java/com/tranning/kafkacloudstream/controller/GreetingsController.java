package com.tranning.kafkacloudstream.controller;

import com.tranning.kafkacloudstream.model.Greetings;
import com.tranning.kafkacloudstream.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    private final GreetingService greetingService;

    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetings")
    public String greetings(@RequestParam("message") String message) {
        Greetings greetings = new Greetings();
        greetings.setMessage("testing");
        greetings.setTimestamp(System.currentTimeMillis());
        greetingService.sendGreeting(greetings);
        return "success";
    }
}
