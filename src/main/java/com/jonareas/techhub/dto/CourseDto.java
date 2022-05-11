package com.jonareas.techhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
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
public class CourseDto extends BaseDto  {

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

    @JsonIncludeProperties(value = {"fullName", "photoPath"})
    private InstructorDto instructor;

    @JsonIncludeProperties(value = {"name"})
    private TopicDto topic;


}
