package com.marvel.gateway.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = -4751428313085361617L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate modified;

    private String resourceURI;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Url> urls = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Thumbnail thumbnail;

    @OneToOne(cascade = CascadeType.ALL)
    private Comic comics;

    @OneToOne(cascade = CascadeType.ALL)
    private Storie stories;

    @OneToOne(cascade = CascadeType.ALL)
    private Event events;

    @OneToOne(cascade = CascadeType.ALL)
    private Serie series;

}