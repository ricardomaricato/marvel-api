package com.marvel.gateway.services;

import com.marvel.gateway.models.entities.Hero;
import com.marvel.gateway.models.request.ApiMarvelRequest;

import java.util.List;

public interface ApiMarvelService {

    Hero createNewHero(Hero hero);
    List<Hero> getCreatorCollection(ApiMarvelRequest request);
    Hero getCharacterIndividual(Long characterId);

}