package com.marvel.gateway.services;

import com.marvel.gateway.models.entities.*;
import com.marvel.gateway.models.enums.Order;
import com.marvel.gateway.models.request.ApiMarvelRequest;
import com.marvel.gateway.repositories.ApiMarvelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ApiMarvelServiceImplTest {

    @Mock
    private ApiMarvelRepository repository;

    @InjectMocks
    private ApiMarvelServiceImpl service;

    @Test
    public void makeANewHeroWithSucess() {
        //Scenario
        Hero hero = makeHeroMock();

        //Execution
        Hero newHero = service.createNewHero(hero);
        when(repository.save(hero)).thenReturn(newHero);

        //Assertion
        verify(repository, times(1)).save(hero);
    }

    @Test
    public void findHeroByFiltersWithSucess() {
        //Scenario
        ApiMarvelRequest apiMarvelRequest = makeApiMarvelRequest();

        //Execution
        when(repository.findAll(any(Specification.class))).thenReturn((Arrays.asList(makeHeroMock())));
        service.getCreatorCollection(apiMarvelRequest);

        //Assertion
        verify(repository, times(1)).findAll(any(Specification.class));
    }

    @Test
    public void findHeroByCharacterIndividualWithSucess() {
        //Scenario
        Long characterIndividual = 1L;

        //Execution
        when(repository.findById(characterIndividual)).thenReturn(Optional.of(makeHeroMock()));
        service.getCharacterIndividual(characterIndividual);

        //Assertion
        verify(repository, times(1)).findById(characterIndividual);
    }

    private Hero makeHeroMock() {
        return Hero
                .builder()
                .code("1")
                .status("TEXT")
                .copyright("TEXT")
                .attributionText("TEXT")
                .attributionHTML("TEXT")
                .results(Arrays.asList(makeResultMock()))
                .etag("TEXT")
                .build();
    }

    private Result makeResultMock() {
        return Result
                .builder()
                .id(1L)
                .name("TEXT")
                .description("TEXT")
                .modified(LocalDate.now())
                .resourceURI("TEXT")
                .urls(Arrays.asList(makeUrlMock()))
                .thumbnail(makeThumbnailMock())
                .comics(makeComicMock())
                .stories(makeStorieMock())
                .events(makeEventMock())
                .series(makeSerieMock())
                .build();
    }

    private Url makeUrlMock() {
        return Url
                .builder()
                .id(1L)
                .type("TEXT")
                .url("TEXT")
                .build();
    }

    private Thumbnail makeThumbnailMock() {
        return Thumbnail
                .builder()
                .id(1L)
                .path("TEXT")
                .extension("TEXT")
                .build();
    }

    private Comic makeComicMock() {
        return Comic
                .builder()
                .id(1L)
                .available(1)
                .returned(1)
                .collectionURI("TEXT")
                .items(Arrays.asList(makeItemMock()))
                .build();
    }

    private Storie makeStorieMock() {
        return Storie
                .builder()
                .id(1L)
                .available(1)
                .returned(1)
                .collectionURI("TEXT")
                .items(Arrays.asList(makeItemMock()))
                .build();
    }

    private Event makeEventMock() {
        return Event
                .builder()
                .id(1L)
                .available(1)
                .returned(1)
                .collectionURI("TEXT")
                .items(Arrays.asList(makeItemMock()))
                .build();
    }

    private Serie makeSerieMock() {
        return Serie
                .builder()
                .id(1L)
                .available(1)
                .returned(1)
                .collectionURI("TEXT")
                .items(Arrays.asList(makeItemMock()))
                .build();
    }

    private Item makeItemMock() {
        return Item
                .builder()
                .id(1L)
                .resourceURI("TEXT")
                .name("TEXT")
                .type("TEXT")
                .build();

    }

    private ApiMarvelRequest makeApiMarvelRequest() {
        return ApiMarvelRequest
                .builder()
                .name("TEXT")
                .nameStartsWith("TEXT")
                .modifiedSince(LocalDate.now())
                .comics(1)
                .series(1)
                .events(1)
                .stories(1)
                .orderBy(Order.NAME)
                .limit(1)
                .build();

    }

}