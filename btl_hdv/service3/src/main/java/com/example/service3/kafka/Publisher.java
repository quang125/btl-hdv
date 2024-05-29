package com.example.service3.kafka;

import com.example.service3.Dto;
import com.example.service3.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Publisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String topic1="edit-topic-1";
    private static final String topic2="edit-topic-1";
    public void publish(Dto message) {
        try {
            kafkaTemplate.send(topic1, JsonUtil.toJson(message));
            kafkaTemplate.send(topic2, JsonUtil.toJson(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
