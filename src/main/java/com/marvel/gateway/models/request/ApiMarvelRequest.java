package com.marvel.gateway.models.request;

import com.marvel.gateway.models.enums.Order;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiMarvelRequest {

    @ApiModelProperty(
            value = "Return only characters matching the specified full character name (e.g. Spider-Man).",
            example = "Spider-Man",
            position = 1)
    private String name;

    @ApiModelProperty(
            value = "Return characters with names that begin with the specified string (e.g. Sp).",
            example = "Spider",
            position = 2)
    private String nameStartsWith;

    @ApiParam(name = "modifiedSince",
            value = "Return only characters which have been modified since the specified date.",
            example = "2020-01-13")
    @ApiModelProperty(position = 3)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate modifiedSince;

    @ApiParam(name = "comics",
            value = "Return only characters which appear in the specified comics.",
            example = "1")
    @ApiModelProperty(position = 4)
    private Integer comics;

    @ApiParam(name = "series",
            value = "Return only characters which appear the specified series.",
            example = "1")
    @ApiModelProperty(position = 5)
    private Integer series;

    @ApiParam(name = "events",
            value = "Return only characters which appear in the specified events.",
            example = "1")
    @ApiModelProperty(position = 6)
    private Integer events;

    @ApiParam(name = "stories",
            value = "Return only characters which appear the specified stories.",
            example = "1")
    @ApiModelProperty(position = 7)
    private Integer stories;

    @ApiModelProperty(
            value = "Order the result set by a field or fields. Add a \"-\" to the value sort in descending order. Multiple values are given priority in the order in which they are passed.",
            position = 8,
            required = true
    )
    private Order orderBy;

    @NotNull(message = "{limit.not.null}")
    @ApiParam(name = "limit",
            value = "Limit the result set to the specified number of resources.",
            example = "1",
            required = true)
    @ApiModelProperty(position = 9)
    private Integer limit;

}