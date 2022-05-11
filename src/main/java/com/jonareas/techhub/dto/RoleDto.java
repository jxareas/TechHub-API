package com.jonareas.techhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto extends BaseDto {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Boolean enabled;
}
