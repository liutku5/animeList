package com.example.demo.services;

import com.example.demo.model.Anime;
import com.example.demo.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;

    public Iterable<Anime> findAll(){
        return animeRepository.findAll();
    }

    public Optional<Anime> findById(Long id){
        return animeRepository.findById(id);
    }

    public Anime save(Anime anime){
        return animeRepository.save(anime);
    }

    public void deleteById(long id){
        animeRepository.deleteById(id);
    }
}
