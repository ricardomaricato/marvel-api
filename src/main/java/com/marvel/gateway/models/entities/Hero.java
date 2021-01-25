package com.marvel.gateway.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero implements Serializable {

    private static final long serialVersionUID = 4683571838170170282L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

    private String code;

    private String status;

    private String copyright;

    private String attributionText;

    private String attributionHTML;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Result> results = new ArrayList<>();

    private String etag;

}