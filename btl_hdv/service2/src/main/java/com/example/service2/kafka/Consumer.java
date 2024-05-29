package com.example.service2.kafka;

import com.example.service2.Dto;
import com.example.service2.JsonUtil;
import com.example.service2.Service;
import com.fasterxml.jackson.core.JsonProcessingException;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {
    private final Service service;
    @KafkaListener(topicPattern = "edit-topic-2")
    public void add1(String message) throws JsonProcessingException {
        Dto dto= JsonUtil.fromJson(message, Dto.class);
        service.add(dto);
    }
}
