package com.example.service2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Service {
    private final Repository repository;
    public void add(Dto dto){
        Model model=new Model();
        model.setName(dto.getName());
        repository.save(model);
    }
    public List<Model> read(){
        return repository.findAll();
    }
}
