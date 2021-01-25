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
public class ThumbnailDTO implements Serializable {

    private static final long serialVersionUID = 5348823892533567157L;

    @NotBlank(message = "{path.not.blank}")
    @ApiModelProperty(position = 1)
    private String path;

    @NotBlank(message = "{extension.not.blank}")
    @ApiModelProperty(position = 2)
    private String extension;

}