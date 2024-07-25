package com.example.demo.repository;

import com.example.demo.model.Anime;
import com.example.demo.model.Source;
import org.springframework.data.repository.CrudRepository;

public interface SourceRepository extends CrudRepository<Source,Long> {
}
