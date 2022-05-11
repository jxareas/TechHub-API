package com.jonareas.techhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto extends BaseDto {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String password;

    @NotNull
    @NotEmpty
    @Email
    @Size(min = 5, max = 50)
    private String email;

    @NotNull
    private Boolean enabled;

    @NotNull
    private Long idRole;
}
