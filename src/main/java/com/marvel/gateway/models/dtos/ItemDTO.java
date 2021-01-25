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
public class ItemDTO implements Serializable {

    private static final long serialVersionUID = -5527523160264335301L;

    @NotBlank(message = "{resourceURI.not.blank}")
    @ApiModelProperty(position = 1)
    private String resourceURI;

    @NotBlank(message = "{name.not.blank}")
    @ApiModelProperty(position = 2)
    private String name;

    @NotBlank(message = "{type.not.blank}")
    @ApiModelProperty(position = 3)
    private String type;

}