package com.tranning.kafkacloudstream.service;

import com.tranning.kafkacloudstream.config.GreetingStreams;
import com.tranning.kafkacloudstream.model.Greetings;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class GreetingService {
    private final GreetingStreams greetingStreams;

    public GreetingService(GreetingStreams greetingStreams) {
        this.greetingStreams = greetingStreams;
    }

    public void sendGreeting(final Greetings greetings) {
        MessageChannel messageChannel = greetingStreams.outputGreeting();
        messageChannel.send(MessageBuilder
            .withPayload(greetings)
            .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
            .build()
        );
    }
}
