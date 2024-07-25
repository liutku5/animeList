package com.example.demo.services;

import com.example.demo.model.Source;
import com.example.demo.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SourceService {
    @Autowired
    private SourceRepository sourceRepository;

    public Iterable<Source> findAll(){
        return sourceRepository.findAll();
    }

    public Optional<Source> findById(Long id){
        return sourceRepository.findById(id);
    }

    public Source save(Source source){
        return sourceRepository.save(source);
    }

    public void deleteById(long id){
        sourceRepository.deleteById(id);
    }
}
