package com.marvel.gateway.models.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlDTO implements Serializable {

    private static final long serialVersionUID = -760618218306012510L;

    @NotBlank(message = "{type.not.blank}")
    @ApiModelProperty(position = 1)
    private String type;

    @NotBlank(message = "{url.not.blank}")
    @ApiModelProperty(position = 2)
    private String url;

}