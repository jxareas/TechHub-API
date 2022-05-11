package com.jonareas.techhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicDto extends BaseDto {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Integer totalCourses;

    @NotNull
    @NotEmpty
    private String imageUrl;

}
