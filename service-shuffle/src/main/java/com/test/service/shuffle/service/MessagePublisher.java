package com.test.service.shuffle.service;

public interface MessagePublisher {
    <T> void publish(String topic, T message);
}