package com.test.service.shuffle.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher implements MessagePublisher {
    @Value("${spring.application.name}")
    private String microserviceName;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaMessagePublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public <T> void publish(String topic, T message) {
        kafkaTemplate.send(topic, microserviceName, message);
        System.out.printf("Message sent to Kafka: topic=%s, key=%s, message=%s%n", topic, microserviceName, message);
    }
}

