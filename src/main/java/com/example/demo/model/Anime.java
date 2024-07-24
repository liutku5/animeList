package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "anime")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @Column(name = "name_jp")
    private String nameJP;

    @Column(name = "name_en")
    private String nameEN;

    @Column(name = "release_date")
    private String releaseDate;


    @Column(name = "source_id")
    private long sourceId;

    @Column(name = "episodes")
    private long episodes;

    @Column(name = "description")
    private String description;

    @Column(name = "studio")
    private String studio;

}
