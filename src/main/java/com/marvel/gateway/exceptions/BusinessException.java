package com.marvel.gateway.exceptions;

import com.marvel.gateway.models.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private final ErrorEnum errorEnum;

}