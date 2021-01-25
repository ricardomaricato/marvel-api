package com.marvel.gateway.models.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroDTO implements Serializable {

    private static final long serialVersionUID = -5743040852740589613L;

    @NotBlank(message = "{code.not.blank}")
    @ApiModelProperty(position = 1)
    private String code;

    @NotBlank(message = "{status.not.blank}")
    @ApiModelProperty(position = 2)
    private String status;

    @NotBlank(message = "{copyright.not.blank}")
    @ApiModelProperty(position = 3)
    private String copyright;

    @NotBlank(message = "{attributionText.not.blank}")
    @ApiModelProperty(position = 4)
    private String attributionText;

    @NotBlank(message = "{attributionHTML.not.blank}")
    @ApiModelProperty(position = 5)
    private String attributionHTML;

    @NotEmpty(message = "{results.not.empty}")
    @ApiModelProperty(position = 6)
    private List<ResultDTO> results = new ArrayList<>();

    @NotBlank(message = "{etag.not.blank}")
    @ApiModelProperty(position = 7)
    private String etag;

}