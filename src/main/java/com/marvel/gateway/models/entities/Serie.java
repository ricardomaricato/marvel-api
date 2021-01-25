package com.marvel.gateway.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Serie implements Serializable {

    private static final long serialVersionUID = 5545718982742335835L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer available;

    private Integer returned;

    private String collectionURI;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

}