package com.example.service3;

import com.example.service3.kafka.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Publisher publisher;
    private final Service service;
    @GetMapping("/read")
    public ResponseEntity<?> read(){
        return ResponseEntity.ok(service.read());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Dto dto){
        publisher.publish(dto);
        service.add(dto);
        return ResponseEntity.ok("Add success!");
    }
}
