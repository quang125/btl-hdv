package com.example.query1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Service service;
    @GetMapping("/read")
    public ResponseEntity<?> read(){
        return ResponseEntity.ok(service.read());
    }

}
