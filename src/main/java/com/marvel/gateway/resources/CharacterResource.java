package com.marvel.gateway.resources;

import com.marvel.gateway.models.dtos.HeroDTO;
import com.marvel.gateway.models.entities.Hero;
import com.marvel.gateway.models.errors.ErrorDTO;
import com.marvel.gateway.models.request.ApiMarvelRequest;
import com.marvel.gateway.services.ApiMarvelService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Validated
@RestController
@AllArgsConstructor
@Api(tags = {"Characters"}, description = "Save The Heroes")
@RequestMapping("/characters")
public class CharacterResource {

    private final ApiMarvelService service;
    private final ConverterHero converter;

    @GetMapping
    @ApiOperation(value = "Fetches lists of comic characters with optional filters." +
            "See notes on individual parameters below.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = HeroDTO.class),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorDTO.class)
    })
    public List<HeroDTO> getCreatorCollection(@Valid ApiMarvelRequest request) {
        log.info("START CONSULT: {} ", request);
        List<Hero> heroList = service.getCreatorCollection(request);

        List<HeroDTO> heroDTOList = heroList
                .stream()
                .map(Hero -> converter.toDTO(Hero))
                .collect(Collectors.toList());

        return heroDTOList;
    }

    @GetMapping("/{characterId}")
    @ApiOperation(value = "This method fetches a single character resource." +
            "It is the canonical URI for any character resource provided by the API.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = HeroDTO.class),
            @ApiResponse(code = 404, message = "Charecter Not Found", response = ErrorDTO.class)
    })
    public HeroDTO getCharacterIndividual(
            @ApiParam(name = "characterId",
                    value = "CharacterId of Hero",
                    example = "1",
                    required = true)
            @PathVariable("characterId") Long characterId) {
        log.info("START CONSULT: {} ", characterId);
        Hero hero = service.getCharacterIndividual(characterId);

        return converter.toDTO(hero);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Hero.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorDTO.class),
    })
    public ResponseEntity<Hero> createNewHero(UriComponentsBuilder uriComponentsBuilder, @RequestBody @Valid HeroDTO heroDTO) {
        Hero hero = converter.toEntity(heroDTO);

        log.info("CREATE NEW HERO: {} ", hero);
        Hero newHero = service.createNewHero(hero);

        UriComponents uriComponents = getUriComponents(uriComponentsBuilder, newHero);

        return ResponseEntity.created(uriComponents.toUri()).body(newHero);
    }

    private UriComponents getUriComponents(UriComponentsBuilder uriComponentsBuilder, Hero hero) {
        UriComponents uriComponents =
                uriComponentsBuilder
                        .path("/{characterId}")
                        .buildAndExpand(hero.getCharacterId());
        return uriComponents;
    }

}

@Component
@AllArgsConstructor
class ConverterHero {

    private final ModelMapper modelMapper;

    public Hero toEntity(HeroDTO heroDTO) {
        Hero hero = modelMapper.map(heroDTO, Hero.class);

        return hero;
    }

    public HeroDTO toDTO(Hero hero) {
        HeroDTO heroDTO = modelMapper.map(hero, HeroDTO.class);

        return heroDTO;
    }

}