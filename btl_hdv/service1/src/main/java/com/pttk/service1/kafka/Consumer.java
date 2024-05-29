package com.pttk.service1.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.pttk.service1.Dto;
import com.pttk.service1.JsonUtil;
import com.pttk.service1.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {
    private final Service service;
    @KafkaListener(topicPattern = "edit-topic-1")
    public void add(String message) throws JsonProcessingException {
        Dto dto= JsonUtil.fromJson(message, Dto.class);
        service.add(dto);
    }
}
