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
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseCreateDto extends BaseDto {


    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String description;

    @NotEmpty
    @NotNull
    private String imageUrl;

    @NotNull
    private String imageContentDesc;

    @NotNull
    private Integer steps;

    @NotNull
    private Integer step;

    @NotNull
    private Long instructorId;

    @NotNull
    private Long topicId;


}
