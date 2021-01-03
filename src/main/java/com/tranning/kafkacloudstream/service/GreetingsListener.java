package com.tranning.kafkacloudstream.service;

import com.tranning.kafkacloudstream.config.GreetingStreams;
import com.tranning.kafkacloudstream.model.Greetings;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class GreetingsListener {
    @StreamListener(GreetingStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        System.out.println(greetings.toString());
    }

    @StreamListener(GreetingStreams.OUTPUT)
    public void handleGreetingOutPut(@Payload Greetings greetings) {
        System.out.println(greetings.toString());
    }
}
