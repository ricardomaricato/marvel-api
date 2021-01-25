package com.marvel.gateway.models.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorieDTO implements Serializable {

    private static final long serialVersionUID = 115038618409281853L;

    @NotNull(message = "{available.not.null}")
    @ApiModelProperty(position = 1)
    private Integer available;

    @NotNull(message = "{returned.not.null}")
    @ApiModelProperty(position = 2)
    private Integer returned;

    @NotBlank(message = "{collectionURI.not.blank}")
    @ApiModelProperty(position = 3)
    private String collectionURI;

    @NotEmpty(message = "{items.not.empty}")
    @ApiModelProperty(position = 4)
    private List<ItemDTO> items;

}