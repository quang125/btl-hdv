package com.example.command1.kafka;

import com.example.command1.Dto;
import com.example.command1.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Publisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String topic1="topic-1";
    private static final String topic2="topic-2";
    private static final String topic3="topic-3";
    public void publish(Dto message) {
        try {
            kafkaTemplate.send(topic1, JsonUtil.toJson(message));
            kafkaTemplate.send(topic2, JsonUtil.toJson(message));
            kafkaTemplate.send(topic3, JsonUtil.toJson(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
