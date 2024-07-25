package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "source")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // Correct property name
@Getter
@Setter
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "source_id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Anime> anime;
}
