package com.example.demo.bootstrap;

import com.example.demo.repository.AnimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AnimeRepository animeRepository;
    private Logger logger = LoggerFactory.getLogger(BootStrapData.class);

    public BootStrapData(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }
    @Override
    public void run(String... args) {
        System.out.println("labas");
//        System.out.print(animeRepository.findAll());
        System.out.println(animeRepository.findById(2l));
    }
}
