package com.example.demo.controllers;

import com.example.demo.model.Source;
import com.example.demo.services.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @GetMapping
    public Iterable<Source> getAllSource(){
        return sourceService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Source> getSourceById(@PathVariable Long id){
        Optional<Source> source = sourceService.findById(id);
        if(source.isPresent()){
            return ResponseEntity.ok(source.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Source createSource(@RequestBody Source source){
        System.out.println("hi");
        System.out.println(source);

        System.out.println("--------------------------------------------------");
        return sourceService.save(source);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Source> updateSource(@PathVariable Long id, @RequestBody Source sourceDetails){
        Optional<Source> source = sourceService.findById(id);
        if(source.isPresent()){
            Source updateSource = source.get();
            updateSource.setName(sourceDetails.getName());
            return ResponseEntity.ok(sourceService.save(updateSource));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSource(@PathVariable Long id){
        sourceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}























