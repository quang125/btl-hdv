package com.example.query1.kafka;


import com.example.query1.Dto;
import com.example.query1.JsonUtil;
import com.example.query1.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {
    private final Service service;
    @KafkaListener(topicPattern = "topic-1")
    public void add(String message) throws JsonProcessingException {
        Dto dto= JsonUtil.fromJson(message, Dto.class);
        service.add(dto);
    }
}
