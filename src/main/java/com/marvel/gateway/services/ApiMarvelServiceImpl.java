package com.marvel.gateway.services;

import com.marvel.gateway.exceptions.BusinessException;
import com.marvel.gateway.models.entities.Hero;
import com.marvel.gateway.models.request.ApiMarvelRequest;
import com.marvel.gateway.repositories.ApiMarvelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.marvel.gateway.models.enums.ErrorEnum.CHARACTER_NOT_FOUND;
import static com.marvel.gateway.models.enums.ErrorEnum.EXCEEDED_RESULTS_LIMITED;
import static com.marvel.gateway.repositories.specifications.ApiMarvelSpecification.*;

@Slf4j
@Service
@AllArgsConstructor
public class ApiMarvelServiceImpl implements ApiMarvelService {

    private final ApiMarvelRepository repository;

    @Override
    public Hero createNewHero(Hero hero) {
        return repository.save(hero);
    }

    @Override
    public List<Hero> getCreatorCollection(ApiMarvelRequest request) {
        if (request.getLimit() == 0 || request.getLimit() > 100) throw new BusinessException(EXCEEDED_RESULTS_LIMITED);

        List<Hero> heroList = repository.findAll(
                getHeroSpecification(request))
                .stream()
                .limit(request.getLimit())
                .collect(Collectors.toList());

        if (!heroList.isEmpty()) log.error("HERO CONSULTED: {} ", heroList);

        return heroList;
    }


    @Override
    public Hero getCharacterIndividual(Long characterId) {
        Optional<Hero> hero = repository.findById(characterId);

        if (!hero.isPresent()) log.error("HERO CONSULTED: {} ", CHARACTER_NOT_FOUND.message);
        else log.info("HERO CONSULTED: {} ", hero);

        return hero
                .orElseThrow(() -> new BusinessException(CHARACTER_NOT_FOUND));
    }

    public static Specification<Hero> getHeroSpecification(ApiMarvelRequest request) {
        return heroWithName(request.getName(), request.getOrderBy().name())
                .or(heroWithNameStartsWith(request.getName(), request.getOrderBy().name()))
                .or(heroWithComic(request.getComics(), request.getOrderBy().name())
                        .or(heroWithStorie(request.getStories(), request.getOrderBy().name())
                                .or(heroWithEvent(request.getEvents(), request.getOrderBy().name())
                                        .or(heroWithSerie(request.getSeries(), request.getOrderBy().name())
                                                .or(heroWithModifiedSince(request.getModifiedSince(), request.getOrderBy().name())
                                                )
                                        )
                                )
                        )
                );
    }

}