package com.example.demo.repository;

import com.example.demo.model.Anime;
import org.springframework.data.repository.CrudRepository;

public interface AnimeRepository extends CrudRepository<Anime,Long> {

}
