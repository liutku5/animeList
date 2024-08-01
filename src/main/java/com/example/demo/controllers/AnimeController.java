package com.example.demo.controllers;

import com.example.demo.model.Anime;
import com.example.demo.model.Source;
import com.example.demo.services.AnimeService;
import com.example.demo.services.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping
    public Iterable<Anime> getAllAnime(){
        return animeService.findAll();
    }

//    @GetMapping("/all")
//    public List<Anime> getAllAnime() {
//        Iterable<Anime> animeIterable = animeService.findAll();
//        for (Anime anime : animeIterable) {
//            SourceService sourceService = new SourceService();
//            Source source = sourceService.findById(anime.getSource().getId()).orElse(null);
//            if (source != null) {
//                anime.setSource(source);
//            }
//        }
//        return (List<Anime>) animeIterable;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable Long id){
        Optional<Anime> anime = animeService.findById(id);
        if(anime.isPresent()){
            return ResponseEntity.ok(anime.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Anime createAnime(@RequestBody Anime anime){
        System.out.println("hi");
        System.out.println(anime);
        System.out.println("--------------------------------------------------");
        return animeService.save(anime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anime> updateAnime(@PathVariable Long id, @RequestBody Anime animeDetails){
        Optional<Anime> anime = animeService.findById(id);
        if(anime.isPresent()){
            Anime updateAnime = anime.get();
            updateAnime.setNameJP(animeDetails.getNameJP());
            updateAnime.setNameEN(animeDetails.getNameEN());
            updateAnime.setReleaseDate(animeDetails.getReleaseDate());
            updateAnime.setSource(animeDetails.getSource());
            updateAnime.setEpisodes(animeDetails.getEpisodes());
            updateAnime.setDescription(animeDetails.getDescription());
            updateAnime.setStudio(animeDetails.getStudio());
            updateAnime.setImage(animeDetails.getImage());
            return ResponseEntity.ok(animeService.save(updateAnime));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable Long id){
        animeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}























