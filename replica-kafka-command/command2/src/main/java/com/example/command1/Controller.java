package com.example.command1;

import com.example.command1.kafka.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Publisher publisher;
    private final Service service;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Dto dto){
        publisher.publish(dto);
        service.add(dto);
        return ResponseEntity.ok("Add success!");
    }
}
