package com.marvel.gateway.models.enums;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorEnum {
    CHARACTER_NOT_FOUND(HttpStatus.NOT_FOUND, "character.not.found"),
    EXCEEDED_RESULTS_LIMITED(HttpStatus.CONFLICT, "limit.results.exception"); //TODO: REVER

    public HttpStatus status;
    public String message;

}