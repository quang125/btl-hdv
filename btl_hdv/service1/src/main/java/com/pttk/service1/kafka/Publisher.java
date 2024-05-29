package com.pttk.service1.kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.pttk.service1.Dto;
import com.pttk.service1.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Publisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String topic2="edit-topic-2";
    private static final String topic3="edit-topic-3";
    public void publish(Dto message) {
        try {
            kafkaTemplate.send(topic2, JsonUtil.toJson(message));
            kafkaTemplate.send(topic3, JsonUtil.toJson(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
