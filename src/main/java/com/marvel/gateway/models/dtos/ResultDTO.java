package com.marvel.gateway.models.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = 935964963500465223L;

    @NotBlank(message = "{name.not.blank}")
    @ApiModelProperty(position = 1)
    private String name;

    @NotBlank(message = "{description.not.blank}")
    @ApiModelProperty(position = 2)
    private String description;

    @NotNull(message = "{modified.not.null}")
    @ApiModelProperty(position = 3, example = "2021-01-13")
    private LocalDate modified;

    @NotBlank(message = "{resourceURI.not.blank}")
    @ApiModelProperty(position = 4)
    private String resourceURI;

    @NotEmpty(message = "{urls.not.empty}")
    @ApiModelProperty(position = 5)
    private List<UrlDTO> urls;

    @NotBlank(message = "{thumbnail.not.blank}")
    @ApiModelProperty(position = 6)
    private ThumbnailDTO thumbnail;

    @NotBlank(message = "{comics.not.blank}")
    @ApiModelProperty(position = 7)
    private ComicDTO comics;

    @NotBlank(message = "{stories.not.blank}")
    @ApiModelProperty(position = 8)
    private StorieDTO stories;

    @NotBlank(message = "{events.not.blank}")
    @ApiModelProperty(position = 9)
    private EventDTO events;

    @NotEmpty(message = "{series.not.empty}")
    @ApiModelProperty(position = 10)
    private SerieDTO series;

}