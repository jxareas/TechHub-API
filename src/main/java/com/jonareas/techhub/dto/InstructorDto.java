package com.jonareas.techhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstructorDto extends BaseDto {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String fullName;

    @NotNull
    private Boolean male;

    @NotEmpty
    @NotNull
    private String photoPath;

}
