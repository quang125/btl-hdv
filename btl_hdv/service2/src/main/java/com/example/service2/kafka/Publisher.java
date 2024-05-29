package com.example.service2.kafka;


import com.example.service2.Dto;
import com.example.service2.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Publisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String topic1="edit-topic-1";
    private static final String topic3="edit-topic-3";
    public void publish(Dto message) {
        try {
            kafkaTemplate.send(topic1, JsonUtil.toJson(message));
            kafkaTemplate.send(topic3, JsonUtil.toJson(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
