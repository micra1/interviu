package com.test.service.log.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogConsumer {
    @KafkaListener(topics = "logs.http.requests", groupId = "logging-service")
    public void consume(final String logRequest) {
        //TODO: Maybe add some logic here
        log.info("Received log: {}", logRequest);
    }
}
