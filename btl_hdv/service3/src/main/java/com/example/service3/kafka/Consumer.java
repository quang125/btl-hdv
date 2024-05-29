package com.example.service3.kafka;

import com.example.service3.Dto;
import com.example.service3.JsonUtil;
import com.example.service3.Model;
import com.example.service3.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {
    private final Service service;
    @KafkaListener(topicPattern = "edit-topic-3")
    public void add(String message) throws JsonProcessingException {
        Dto dto=JsonUtil.fromJson(message, Dto.class);
        service.add(dto);
    }
}
